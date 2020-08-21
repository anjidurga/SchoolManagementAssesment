package com.scl.management.content.setup.util;

import com.liferay.exportimport.kernel.configuration.ExportImportConfigurationConstants;
import com.liferay.exportimport.kernel.configuration.ExportImportConfigurationSettingsMapFactory;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerKeys;
import com.liferay.exportimport.kernel.model.ExportImportConfiguration;
import com.liferay.exportimport.kernel.service.ExportImportConfigurationLocalServiceUtil;
import com.liferay.exportimport.kernel.service.ExportImportLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import com.scl.management.content.setup.ContentSetupPath;
import com.scl.management.content.setup.constants.ContentSetupKeys;

import java.io.InputStream;
import java.io.Serializable;

import java.util.Map;

public class LARImporter {

	/**
	 * A Layout is required to build ImportPortlet SettingsMap for
	 * successful LAR import
	 *
	 * @param groupId
	 */
	public static void createDefaultLayoutIfNotExisting(long groupId)
		throws PortalException {

		Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
			groupId, false, "/home");

		if (layout != null) {
			return;
		}

		long companyId = PortalUtil.getDefaultCompanyId();

		long userId = UserLocalServiceUtil.getDefaultUserId(companyId);
		ServiceContext serviceContext = new ServiceContext();

		LayoutLocalServiceUtil.addLayout(
			userId, groupId, false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			"HOME", null, null, LayoutConstants.TYPE_PORTLET, true, "/home",
			serviceContext);
	}

	/**
	 * Import LAR File. Adapted from GroovyLARImporter.importLayoutLAR and
	 * GroovyLARUtil.importLayouts
	 *
	 * @param groupId
	 * @param fileName
	 */
	public static void importLayoutLAR(long groupId, String fileName)
		throws Exception {

		long companyId = PortalUtil.getDefaultCompanyId();

		User admin = ContentSetupUtil.getUserAdmin(companyId);

		PermissionChecker originalPermissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		PermissionChecker adminPermissionChecker =
			PermissionCheckerFactoryUtil.create(admin);

		PermissionThreadLocal.setPermissionChecker(adminPermissionChecker);

		try (InputStream inputStream = getResourceAsStream(fileName)) {
			Map<String, String[]> parameterMap = LARUtil.getParameterMap();

			parameterMap.put(
				PortletDataHandlerKeys.LAYOUTS_IMPORT_MODE,
				new String[] {
					PortletDataHandlerKeys.
						LAYOUTS_IMPORT_MODE_CREATED_FROM_PROTOTYPE
				});

			Map<String, Serializable> importLayoutSettingsMap =
				ExportImportConfigurationSettingsMapFactory.
					buildImportLayoutSettingsMap(
						admin, groupId, true, null, parameterMap);

			ExportImportConfiguration exportImportConfiguration =
				ExportImportConfigurationLocalServiceUtil.
					addDraftExportImportConfiguration(
						admin.getUserId(),
						ExportImportConfigurationConstants.TYPE_IMPORT_LAYOUT,
						importLayoutSettingsMap);

			ExportImportLocalServiceUtil.importLayouts(
				exportImportConfiguration, inputStream);

			if (_log.isInfoEnabled()) {
				_log.info(
					String.format(
						"Successfully imported layout LAR with groupId=%s, " +
							"fileName=%s",
						groupId, fileName));
			}
		}
		catch (Exception e) {
			_log.error(
				String.format(
					"Error importing layout LAR with groupId=%s, fileName=%s",
					groupId, fileName),
				e);

			throw e;
		}
		finally {
			PermissionThreadLocal.setPermissionChecker(
				originalPermissionChecker);
		}
	}

	/**
	 * Import LAR File.
	 *
	 * @param groupId
	 * @param fileName
	 * @param portletId
	 */
	public static void importPortletLAR(
			long groupId, String fileName, String portletId)
		throws Exception {

		long companyId = PortalUtil.getDefaultCompanyId();

		User admin = ContentSetupUtil.getUserAdmin(companyId);

		createDefaultLayoutIfNotExisting(groupId);

		PermissionChecker originalPermissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		PermissionChecker adminPermissionChecker =
			PermissionCheckerFactoryUtil.create(admin);

		PermissionThreadLocal.setPermissionChecker(adminPermissionChecker);

		try (InputStream inputStream = getResourceAsStream(fileName)) {
			LARUtil.importPortletInfo(admin, groupId, portletId, inputStream);

			if (_log.isInfoEnabled()) {
				_log.info(
					String.format(
						"Successfully imported portlet LAR with groupId=%s, " +
							"fileName=%s, portletId=%s",
						groupId, fileName, portletId));
			}
		}
		finally {
			PermissionThreadLocal.setPermissionChecker(
				originalPermissionChecker);
		}
	}

	protected static InputStream getResourceAsStream(String fileName) {
		ClassLoader contentSetupClassLoader =
			ContentSetupPath.class.getClassLoader();

		InputStream inputStream = contentSetupClassLoader.getResourceAsStream(
			ContentSetupKeys.RESOURCES_DIRECTORY + fileName);

		return inputStream;
	}

	private static Log _log = LogFactoryUtil.getLog(LARImporter.class);

}