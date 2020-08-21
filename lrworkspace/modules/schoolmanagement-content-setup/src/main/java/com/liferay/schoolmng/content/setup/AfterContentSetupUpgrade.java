package com.liferay.schoolmng.content.setup;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Release;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AfterContentSetupUpgrade.class)
public class AfterContentSetupUpgrade {

	@Activate
	protected void activate() throws Exception {
	}

	@Reference(
		target = "(&(release.bundle.symbolic.name=schoolmanagement.content.setup)(release.schema.version=1.0.0))",
		unbind = "-"
	)
	protected void setRelease(Release release) {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AfterContentSetupUpgrade.class);

}