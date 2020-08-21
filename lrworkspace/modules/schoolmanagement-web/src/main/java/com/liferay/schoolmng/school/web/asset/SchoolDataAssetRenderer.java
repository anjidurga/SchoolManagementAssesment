package com.liferay.schoolmng.school.web.asset;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.schoolmng.school.model.SchoolData;
import com.liferay.schoolmng.school.service.permission.SchoolDataPermissionChecker;
import com.liferay.schoolmng.school.web.constants.MVCCommandNames;
import com.liferay.schoolmng.school.web.constants.SchoolPortletKeys;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Asset Render for School Data
 *
 * @author Anjaneya
 *
 */
public class SchoolDataAssetRenderer extends BaseJSPAssetRenderer<SchoolData> implements TrashRenderer  {
	
	 public SchoolDataAssetRenderer(SchoolData schooldataObj, SchoolDataPermissionChecker resourceBundleLoader) {
	      this._schooldataObj = schooldataObj;
	      this._schoolDataPermissionChecker = resourceBundleLoader;
	 }
	 
	 @Override
	 public SchoolData getAssetObject() {
	      return _schooldataObj;
	 }
	 @Override
	 public long getGroupId() {
	     return _schooldataObj.getGroupId();
	 }
	 @Override
	 public long getUserId() {
	     return _schooldataObj.getUserId();
	 }

	 @Override
	 public String getUserName() {
	     return _schooldataObj.getUserName();
	 }

	 @Override
	 public String getUuid() {
	     return _schooldataObj.getUuid();
	 }
	 @Override
	 public String getClassName() {
	     return SchoolData.class.getName();
	 }

	 @Override
	 public long getClassPK() { 
	     return _schooldataObj.getSchoolId();
	 }

	 @Override
	 public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {		 
	     return _schooldataObj.getSchoolName()+ "by "+_schooldataObj.getUserName()+",from:"+_schooldataObj.getCreateDate();
	  }
	 
	 @Override
		public String getPortletId() {
			AssetRendererFactory<SchoolData> assetRendererFactory =
				getAssetRendererFactory();

			return assetRendererFactory.getPortletId();
		}
	 @Override
	 public int getStatus() {
	    // TO-DO : If workflow implemented/ or to hide the records on basis of status then add status column
		 // in schoo table and get the proper status value here.
	     return 1;
	 }

	 @Override
	 public String getTitle(Locale locale) {
	    return _schooldataObj.getSchoolName();
	 }

	 @Override
	 public int getAssetRendererType() {
	    return super.getAssetRendererType();
	 }
	 
	 
	 
	 @Override
	 public String getJspPath(HttpServletRequest request, String template) {		 
	     return "/asset/full_content.jsp";
	 
	 }

	 @Override
	    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
	            LiferayPortletResponse liferayPortletResponse) throws Exception {
			if(_log.isTraceEnabled()) {
				_log.trace("Getting URL for Edit School data in Asset rendere");
			}
		 
	        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
	                getControlPanelPlid(liferayPortletRequest), SchoolPortletKeys.SCHOOL_PORTLET_NAME,
	                PortletRequest.RENDER_PHASE);
	       
	        portletURL.setParameter("schoolId", String.valueOf(_schooldataObj.getSchoolId()));
	               
	      
	        portletURL.setParameter(
				 "mvcRenderCommandName", MVCCommandNames.EDIT_SCHOOLDATA);
	        portletURL.setParameter("showback", Boolean.TRUE.toString());
	        
	        if(_log.isTraceEnabled()) {
				_log.trace("portletURL = "+portletURL);
			}
	        
	        return portletURL;
	    }

	

	 @Override
	    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	            LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) 
	                    throws Exception {
		 _log.info("Getting URL for Edit School data in Asset rendere");
		 
	        try {
	            long plid = PortalUtil.getPlidFromPortletId(_schooldataObj.getGroupId(),
	            		SchoolPortletKeys.SCHOOL_PORTLET_NAME);

	            PortletURL portletURL;
	            if (plid == LayoutConstants.DEFAULT_PLID) {
	                portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	                		SchoolPortletKeys.SCHOOL_PORTLET_NAME, PortletRequest.RENDER_PHASE);
	            } else {
	                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	                		SchoolPortletKeys.SCHOOL_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
	            }

	            //portletURL.setParameter("mvcPath", "/view.jsp");
	            portletURL.setParameter("entryId", String.valueOf(_schooldataObj.getSchoolId()));

	            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

	            portletURL.setParameter("redirect", currentUrl);

	            return portletURL.toString();

	        } catch (PortalException e) {

	        } catch (SystemException e) {
	        }

	        return noSuchEntryRedirect;
	    }
	 
	
		@Override
		public String getURLView(
				LiferayPortletResponse liferayPortletResponse, 
				WindowState windowState) 
			throws Exception {
			
			return super.getURLView(liferayPortletResponse, windowState);
		}

  
    	@Override
    	public boolean hasEditPermission(PermissionChecker permissionChecker)
    		throws PortalException {
    		   		
    		boolean hasEdit = _schoolDataPermissionChecker.contains (permissionChecker, _schooldataObj.getGroupId(),
    				_schooldataObj.getSchoolId(), ActionKeys.UPDATE);
    		
    		if(_log.isDebugEnabled()) {
    			_log.debug("Checking permisssion for Schoolid  =[ "+_schooldataObj.getSchoolId() +" ]" +
    					" groupId = ["+_schooldataObj.getGroupId() +"]" + 
    					" action = ["+ ActionKeys.UPDATE + "]" +
    					"hasEdit = [ "+hasEdit +"]");
    		}
    		 
    		 return hasEdit;
    	}

    	@Override
    	public boolean hasViewPermission(PermissionChecker permissionChecker)
    		throws PortalException {
    		
    		boolean hasView = _schoolDataPermissionChecker.contains(permissionChecker, _schooldataObj.getGroupId(),
     				_schooldataObj.getSchoolId(), ActionKeys.VIEW);
    		
    		if(_log.isTraceEnabled()) {  			
    			_log.trace("hasView for Schoolid  =[ "+_schooldataObj.getSchoolId() +" ] is = " + "[ "+hasView +"]");
    		}

    		return hasView;
    	}
 
	 
		 @Override
		 public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		    request.setAttribute("schooldata", _schooldataObj);
		    return super.include(request, response, template);
		 }
		 
		 private static final Log _log =
					LogFactoryUtil.getLog(SchoolDataAssetRenderer.class);
		 
	
		 
		 private  SchoolData _schooldataObj;
	
		@Override
		public String getType() {
			
			return SchoolDataAssetRendererFactory.TYPE;
		}
		
		
		private SchoolDataPermissionChecker _schoolDataPermissionChecker;

	}
