package com.liferay.schoolmng.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.schoolmng.content.setup.constants.FileNameConstants;
import com.liferay.schoolmng.content.setup.util.ContentSetupUtil;
import com.liferay.sites.kernel.util.SitesUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Upgrade process to create site and apply site-template
 * 
 * @author Anjaneya
 *
 */
public class CreateSiteFromSiteTemplate extends UpgradeProcess {
	
	public CreateSiteFromSiteTemplate(String siteName) {
		this._siteName = siteName;
	}

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub
		if(_log.isInfoEnabled()) {
			_log.info("Start : Create Site ");
		}
		Group group = createSite();
		
		if(_log.isInfoEnabled()) {
			_log.info("Site :"+ group.getName() +" Has been created successfully.");
		}
		
		updateSiteTemplateToSite(group);
		
		if(_log.isInfoEnabled()) {
			_log.info("Site template Has been created successfully.");
		}
		
		
	}
	
	private Group createSite() throws Exception {
		
		long companyId = PortalUtil.getDefaultCompanyId();  
		 
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		
		Group grp = null;
		   try {
		    grp = GroupServiceUtil.getGroup(companyId, _siteName);
		   } catch (Exception e) {
		    
		   }
		   
		   if(grp == null){
			   			   
			   Map<Locale, String> nameMap = new HashMap<>();
			   Map<Locale, String> descriptionMap = new HashMap<>();

			  nameMap.put(LocaleUtil.getDefault(), _siteName);
			  
			  
			  descriptionMap.put(LocaleUtil.getDefault(), _siteName+"description");
			  User user =  ContentSetupUtil.getUserAdmin(companyId);
			  
			 
			
			  if( _log.isInfoEnabled()) {
			   _log.info("User Id ===> [" +user.getUserId() + " ] User name = [ "+user.getFirstName() +"]");
			 }
			  
			  PrincipalThreadLocal.setName(user.getUserId());
			  PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
			  PermissionThreadLocal.setPermissionChecker(permissionChecker);

			 
			   
			   return GroupServiceUtil.addGroup(
						GroupConstants.DEFAULT_PARENT_GROUP_ID,
						GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap,
						descriptionMap,
						GroupConstants.TYPE_SITE_OPEN, true,
						GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, "/"+_siteName, true,
						true, serviceContext);
		   }
		   
		   return grp;
		    
		  
	}
	
	private void updateSiteTemplateToSite(Group grp) throws Exception {
		
		int publicLayoutSetPrototypeId = 0;
		int privateLayoutSetPrototypeId =0;
		long companyId = PortalUtil.getDefaultCompanyId();  
		
		List<LayoutSetPrototype> layoutSetPrototypes=LayoutSetPrototypeServiceUtil.search(companyId,Boolean.TRUE, null);
		  
		   for(LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes){
			  		    
		    if(layoutSetPrototype.getName("").equals(FileNameConstants.SITE_TEMPLATE_NAME_SCHOOL_MANAGEMENT)){     
		     
		     publicLayoutSetPrototypeId = (int) layoutSetPrototype.getLayoutSetPrototypeId();
		    }
		    if(layoutSetPrototype.getName("").equals(FileNameConstants.SITE_TEMPLATE_NAME_SCHOOL_MANAGEMENT)){     
		     
		     privateLayoutSetPrototypeId = (int) layoutSetPrototype.getLayoutSetPrototypeId();
		    }
		   }
		   
		   
		   
		   MethodKey methodKey  = new MethodKey(SitesUtil.class, "updateLayoutSetPrototypesLinks",Group.class,long.class, long.class,boolean.class,boolean.class);
		   PortalClassInvoker.invoke(true, methodKey, grp, publicLayoutSetPrototypeId, privateLayoutSetPrototypeId,true,true);

		   LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(grp.getGroupId(), true);
		   
		   MethodKey _mergeLayoutSetPrototypeLayoutsMethodKey  = new MethodKey(SitesUtil.class,"mergeLayoutSetPrototypeLayouts",Group.class,LayoutSet.class);

		   PortalClassInvoker.invoke(true,_mergeLayoutSetPrototypeLayoutsMethodKey,grp, layoutSet);
		
	}	
	
	private String _siteName;
	
	private static final Log _log = LogFactoryUtil.getLog(
			CreateSiteFromSiteTemplate.class);


}
