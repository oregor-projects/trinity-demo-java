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

import com.oregor.trinity4j.api.ApiResponse;

/**
 * The Create Todo Response.
 *
 * @author PolyGenesis Platform
 */
public class CreateTodoResponse extends ApiResponse {

  private String todoId;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Create Todo Response. */
  @SuppressWarnings("CPD-START")
  public CreateTodoResponse() {
    super();
  }

  /**
   * Instantiates a new Create Todo Response.
   *
   * @param todoId the todo id
   */
  public CreateTodoResponse(String todoId) {
    setTodoId(todoId);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets the Todo Id.
   *
   * @return string
   */
  public String getTodoId() {
    return this.todoId;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets the Todo Id.
   *
   * @param todoId the todo id
   */
  @SuppressWarnings("CPD-END")
  public void setTodoId(String todoId) {
    this.todoId = todoId;
  }
}
