package org.apache.torque.engine.platform;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;

/**
 * @author <a href="mailto:mpoeschl@marmot.at">Martin Poeschl</a>
 * @version $Id: PlatformFactoryTest.java 239624 2005-08-24 12:18:03Z henning $
 */
public class PlatformFactoryTest extends TestCase
{

    public void testGetPlatformFor()
    {
        Platform platform = PlatformFactory.getPlatformFor("mysql");
        assertTrue("org.apache.torque.engine.platform.PlatformMysqlImpl"
                .equals(platform.getClass().getName()));
    }

}
