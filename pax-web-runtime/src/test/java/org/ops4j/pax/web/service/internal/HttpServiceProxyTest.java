/* Copyright 2007 Alin Dreghiciu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.service.internal;

import static org.easymock.EasyMock.createMock;

import org.junit.Test;

public class HttpServiceProxyTest {

	// expect that it does not accept a null delegate
	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullDelegate() {
		new HttpServiceProxy(null);
	}

	// expect that everything gets smooth
	@Test
	public void constructorWithValidDelegate() {
		new HttpServiceProxy(createMock(StoppableHttpService.class));
	}

}
