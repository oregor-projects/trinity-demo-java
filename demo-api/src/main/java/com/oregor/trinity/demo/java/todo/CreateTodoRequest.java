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

import com.oregor.trinity4j.api.ApiRequest;

/**
 * The Create Todo Request.
 *
 * @author PolyGenesis Platform
 */
public class CreateTodoRequest extends ApiRequest {

  private String description;
  private Boolean done;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Create Todo Request. */
  @SuppressWarnings("CPD-START")
  public CreateTodoRequest() {
    super();
  }

  /**
   * Instantiates a new Create Todo Request.
   *
   * @param description the description
   * @param done the done
   */
  public CreateTodoRequest(String description, Boolean done) {
    setDescription(description);
    setDone(done);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

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
