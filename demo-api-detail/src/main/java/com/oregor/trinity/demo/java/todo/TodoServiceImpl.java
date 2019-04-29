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

import com.oregor.trinity4j.commons.assertion.Assertion;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the Todo Service.
 *
 * @author PolyGenesis Platform
 */
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

  private TodoPersistence todoPersistence;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Todo Service Impl.
   *
   * @param todoPersistence the todo persistence
   */
  public TodoServiceImpl(TodoPersistence todoPersistence) {
    this.todoPersistence = todoPersistence;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * Create.
   *
   * @param createTodoRequest the create todo request
   * @return create todo response
   */
  @Override
  public CreateTodoResponse create(CreateTodoRequest createTodoRequest) {

    Assertion.isNotNull(createTodoRequest, "createTodoRequest is required");

    Todo todo =
        new Todo(
            todoPersistence.nextId(),
            createTodoRequest.getDescription(),
            createTodoRequest.getDone());

    todoPersistence.store(todo);

    return new CreateTodoResponse(todo.getId().getRootId().toString());
  }

  /**
   * Modify.
   *
   * @param modifyTodoRequest the modify todo request
   * @return modify todo response
   */
  @Override
  public ModifyTodoResponse modify(ModifyTodoRequest modifyTodoRequest) {

    Assertion.isNotNull(modifyTodoRequest, "modifyTodoRequest is required");

    Todo todo =
        todoPersistence
            .restore(new TodoId(UUID.fromString(modifyTodoRequest.getTodoId())))
            .orElseThrow(() -> new IllegalArgumentException("Cannot restore todo"));

    todoPersistence.store(todo);

    return new ModifyTodoResponse(todo.getId().getRootId().toString());
  }
}
