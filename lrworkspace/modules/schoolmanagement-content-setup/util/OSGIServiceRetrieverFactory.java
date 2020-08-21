package com.scl.management.content.setup.util;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

public class OSGIServiceRetrieverFactory {

	public static <T> OSGIServiceRetriever<T> getOSGIServiceRetriever(
		Class<T> serviceClass) {

		return new OSGIServiceRetrieverImpl<>(serviceClass);
	}

	public interface OSGIServiceRetriever<T> {

		public T getService();

	}

	private static class OSGIServiceRetrieverImpl<T>
		implements OSGIServiceRetriever<T> {

		public OSGIServiceRetrieverImpl(Class<T> serviceClass) {
			_serviceTracker = ServiceTrackerFactory.open(serviceClass);
		}

		public T getService() {
			return _serviceTracker.getService();
		}

		private ServiceTracker<T, T> _serviceTracker;

	}

}