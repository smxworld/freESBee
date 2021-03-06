package org.apache.torque.engine.sql;

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

/**
 * An Exception for parsing SQLToAppData.  This class
 * will probably get some extra features in future.
 *
 * @author <a href="mailto:leon@opticode.co.za">Leon Messerschmidt</a>
 * @version $Id: ParseException.java 239624 2005-08-24 12:18:03Z henning $
 */
public class ParseException extends Exception
{
    /**
     * constructor.
     *
     * @param err error message
     */
    public ParseException(String err)
    {
        super(err);
    }
}
