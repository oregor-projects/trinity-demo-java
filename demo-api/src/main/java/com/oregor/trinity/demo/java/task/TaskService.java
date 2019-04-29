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

package com.oregor.trinity.demo.java.task;

/**
 * Commands contract for Tasks.
 *
 * @author PolyGenesis Platform
 */
public interface TaskService {

  // ===============================================================================================
  // METHODS
  // ===============================================================================================

  /**
   * Create.
   *
   * @param createTaskRequest the create task request
   * @return create task response
   */
  CreateTaskResponse create(CreateTaskRequest createTaskRequest);

  /**
   * Modify.
   *
   * @param modifyTaskRequest the modify task request
   * @return modify task response
   */
  ModifyTaskResponse modify(ModifyTaskRequest modifyTaskRequest);
}
