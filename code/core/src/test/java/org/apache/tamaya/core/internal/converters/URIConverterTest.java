/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tamaya.core.internal.converters;

import org.apache.tamaya.TypeLiteral;
import org.apache.tamaya.spi.ConversionContext;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests conversion of the {@link ClassConverter}.
 */
public class URIConverterTest {

    ConversionContext context = new ConversionContext.Builder(TypeLiteral.of(URI.class))
            .build();

    @Test
    public void testConvert_URI() throws Exception {
        URIConverter converter = new URIConverter();
        assertEquals(new URI("test:path"), converter.convert("test:path", context));
    }

    @Test
    public void testConvert_URI_WithSpaces() throws Exception {
        URIConverter converter = new URIConverter();
        assertEquals(new URI("test:path"), converter.convert("  test:path\t", context));
    }

    @Test
    public void testConvert_URI_WithSpacesBefore() throws Exception {
        URIConverter converter = new URIConverter();
        assertEquals(new URI("test:path"), converter.convert("  test:path", context));
    }

    @Test
    public void testConvert_URI_WithSpacesAfter() throws Exception {
        URIConverter converter = new URIConverter();
        assertEquals(new URI("test:path"), converter.convert("test:path  ", context));
    }

    @Test
    public void testConvert_NotPresent() throws Exception {
        URIConverter converter = new URIConverter();
        assertNull(converter.convert("", context));
        assertNull(converter.convert(null, context));
    }
}
