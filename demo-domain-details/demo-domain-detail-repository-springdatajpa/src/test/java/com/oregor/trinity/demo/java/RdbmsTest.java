/*-
 * ==========================LICENSE_START=================================
 * trinity-demo-java
 * ========================================================================
 * Copyright (C) 2019 Christos Tsakostas, OREGOR LTD
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===========================LICENSE_END==================================
 */

package com.oregor.trinity.demo.java;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Rdbms test
 *
 * @author PolyGenesis Platform
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = RdbmsTestConfig.class,
    properties = {
      // "logging.level.org.hibernate.SQL=debug",
      // "logging.level.org.hibernate.type.descriptor.sql=trace",
      "spring.jpa.show-sql=true",
      "spring.jpa.properties.hibernate.format_sql=false"
    })
@ActiveProfiles({"ci-rdbms"})
@Transactional
public abstract class RdbmsTest {}
