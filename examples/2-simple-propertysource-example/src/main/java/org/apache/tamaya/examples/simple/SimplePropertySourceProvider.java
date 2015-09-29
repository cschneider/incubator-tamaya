/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tamaya.examples.simple;

import org.apache.tamaya.core.propertysource.SimplePropertySource;
import org.apache.tamaya.spi.PropertySource;
import org.apache.tamaya.spi.PropertySourceProvider;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anatole on 20.03.2015.
 */
public class SimplePropertySourceProvider implements PropertySourceProvider {

    @Override
    public Collection<PropertySource> getPropertySources() {
        List<PropertySource> propertySources = new ArrayList<>();
        String[] resources = new String[]{
                "cfgOther/a.properties", "cfgOther/b.properties", "cfgOther/c.properties"};
        for (String res : resources) {
            URL url = ClassLoader.getSystemClassLoader().getResource(res);
            propertySources.add(new SimplePropertySource(url));
        }
        return Collections.unmodifiableList(propertySources);
    }

}
