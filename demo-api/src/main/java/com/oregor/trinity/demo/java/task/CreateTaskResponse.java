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

import com.oregor.trinity4j.api.ApiResponse;

/**
 * The Create Task Response.
 *
 * @author PolyGenesis Platform
 */
public class CreateTaskResponse extends ApiResponse {

  private String taskId;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Create Task Response. */
  @SuppressWarnings("CPD-START")
  public CreateTaskResponse() {
    super();
  }

  /**
   * Instantiates a new Create Task Response.
   *
   * @param taskId the task id
   */
  public CreateTaskResponse(String taskId) {
    setTaskId(taskId);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets the Task Id.
   *
   * @return string
   */
  public String getTaskId() {
    return this.taskId;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets the Task Id.
   *
   * @param taskId the task id
   */
  @SuppressWarnings("CPD-END")
  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }
}
