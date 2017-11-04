/*
 * Copyright 2007 Alin Dreghiciu.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.extender.whiteboard.internal.tracker;

import org.ops4j.pax.web.extender.whiteboard.internal.ExtendedHttpServiceRuntime;
import org.ops4j.pax.web.extender.whiteboard.internal.ExtenderContext;
import org.ops4j.pax.web.extender.whiteboard.internal.element.HttpContextElement;
import org.ops4j.pax.web.service.whiteboard.HttpContextMapping;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Tracks {@link HttpContextMapping}s.
 *
 * @author Alin Dreghiciu
 * @since 0.4.0, April 06, 2008
 */
public class HttpContextMappingTracker extends AbstractHttpContextTracker<HttpContextMapping> {

	/**
	 * Constructor.
	 *  @param extenderContext
	 *            extender context; cannot be null
	 * @param bundleContext
	 * @param httpServiceRuntime
	 */
	private HttpContextMappingTracker(final ExtenderContext extenderContext, final BundleContext bundleContext,
									  ExtendedHttpServiceRuntime httpServiceRuntime) {
		super(extenderContext, bundleContext, httpServiceRuntime);
	}

	public static ServiceTracker<HttpContextMapping, HttpContextElement> createTracker(
			final ExtenderContext extenderContext, final BundleContext bundleContext, ExtendedHttpServiceRuntime httpServiceRuntime) {
		return new HttpContextMappingTracker(extenderContext, bundleContext, httpServiceRuntime).create(HttpContextMapping.class);
	}

	/**
	 * @see AbstractHttpContextTracker#createHttpContextElement(ServiceReference,
	 *      Object)
	 */
	@Override
	HttpContextElement createHttpContextElement(final ServiceReference<HttpContextMapping> serviceReference,
												final HttpContextMapping published) {
		return new HttpContextElement(serviceReference, published);
	}

}
