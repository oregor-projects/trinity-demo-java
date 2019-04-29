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
 * The Modify Task Request.
 *
 * @author PolyGenesis Platform
 */
public class ModifyTaskRequest extends ApiRequest {

  private String taskId;
  private String description;
  private Boolean done;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Modify Task Request. */
  @SuppressWarnings("CPD-START")
  public ModifyTaskRequest() {
    super();
  }

  /**
   * Instantiates a new Modify Task Request.
   *
   * @param taskId the task id
   * @param description the description
   * @param done the done
   */
  public ModifyTaskRequest(String taskId, String description, Boolean done) {
    setTaskId(taskId);
    setDescription(description);
    setDone(done);
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

  /**
   * Gets the Description.
   *
   * @return string
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets the Done.
   *
   * @return boolean
   */
  public Boolean getDone() {
    return this.done;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets the Task Id.
   *
   * @param taskId the task id
   */
  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  /**
   * Sets the Description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the Done.
   *
   * @param done the done
   */
  @SuppressWarnings("CPD-END")
  public void setDone(Boolean done) {
    this.done = done;
  }
}
