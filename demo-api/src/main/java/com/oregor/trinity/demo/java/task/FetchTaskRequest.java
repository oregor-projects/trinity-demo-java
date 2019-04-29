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

import com.oregor.trinity4j.api.ApiRequest;

/**
 * The Fetch Task Request.
 *
 * @author PolyGenesis Platform
 */
public class FetchTaskRequest extends ApiRequest {

  private String taskId;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Fetch Task Request. */
  @SuppressWarnings("CPD-START")
  public FetchTaskRequest() {
    super();
  }

  /**
   * Instantiates a new Fetch Task Request.
   *
   * @param taskId the task id
   */
  public FetchTaskRequest(String taskId) {
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
