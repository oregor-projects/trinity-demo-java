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

package com.oregor.trinity.demo.java.todo;

import static org.assertj.core.api.Assertions.assertThat;

import com.oregor.trinity.demo.java.RdbmsTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Tests for the Todo Persistence Implementation.
 *
 * @author PolyGenesis Platform
 */
public class TodoPersistenceImplTest extends RdbmsTest {

  @Autowired private TodoPersistence todoPersistence;

  // ===============================================================================================
  // TEST CASES
  // ===============================================================================================

  /** Should store and restore aggregate root. */
  @Test
  public void shouldStoreAndRestore() {
    // TODO [PolyGenesis]: write test case
    assertThat(todoPersistence).isNotNull();
  }
}
