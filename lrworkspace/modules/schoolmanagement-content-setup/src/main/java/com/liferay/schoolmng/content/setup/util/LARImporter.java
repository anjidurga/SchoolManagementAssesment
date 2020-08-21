package com.liferay.schoolmng.content.setup.util;

import com.liferay.exportimport.kernel.configuration.ExportImportConfigurationConstants;
import com.liferay.exportimport.kernel.configuration.ExportImportConfigurationSettingsMapFactoryUtil;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerKeys;
import com.liferay.exportimport.kernel.model.ExportImportConfiguration;
import com.liferay.exportimport.kernel.service.ExportImportConfigurationLocalServiceUtil;
import com.liferay.exportimport.kernel.service.ExportImportLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.schoolmng.content.setup.ContentSetupPath;
import com.liferay.schoolmng.content.setup.constants.FileNameConstants;

import java.io.InputStream;
import java.io.Serializable;

import java.util.Map;

/**
 *
 *
 * @author Anjaneya
 *
 */
public class LARImporter {

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
					ExportImportConfigurationSettingsMapFactoryUtil.
						buildImportLayoutSettingsMap(
								admin, groupId, true,
							null, parameterMap);

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

	protected static InputStream getResourceAsStream(String fileName) {
		ClassLoader contentSetupClassLoader =
			ContentSetupPath.class.getClassLoader();

		InputStream inputStream = contentSetupClassLoader.getResourceAsStream(
			FileNameConstants.RESOURCES_DIRECTORY + fileName);

		return inputStream;
	}

	private static Log _log = LogFactoryUtil.getLog(LARImporter.class);

}