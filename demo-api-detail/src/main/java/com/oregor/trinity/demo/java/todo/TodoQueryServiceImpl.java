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
import com.oregor.trinity4j.domain.Paginated;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the Todo Query Service.
 *
 * @author PolyGenesis Platform
 */
@Service
@Transactional
public class TodoQueryServiceImpl implements TodoQueryService {

  private TodoPersistence todoPersistence;
  private TodoConverter todoConverter;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Todo Query Service Impl.
   *
   * @param todoPersistence the todo persistence
   * @param todoConverter the todo converter
   */
  public TodoQueryServiceImpl(TodoPersistence todoPersistence, TodoConverter todoConverter) {
    this.todoPersistence = todoPersistence;
    this.todoConverter = todoConverter;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * Fetch.
   *
   * @param fetchTodoRequest the fetch todo request
   * @return fetch todo response
   */
  @Override
  public FetchTodoResponse fetch(FetchTodoRequest fetchTodoRequest) {

    Assertion.isNotNull(fetchTodoRequest, "fetchTodoRequest is required");

    Todo todo =
        todoPersistence
            .restore(new TodoId(UUID.fromString(fetchTodoRequest.getTodoId())))
            .orElseThrow(() -> new IllegalArgumentException("Cannot restore todo"));

    return new FetchTodoResponse(todo.getDescription(), todo.getDone());
  }

  /**
   * Fetch Collection.
   *
   * @param fetchTodoCollectionRequest the fetch todo collection request
   * @return fetch todo collection response
   */
  @Override
  public FetchTodoCollectionResponse fetchCollection(
      FetchTodoCollectionRequest fetchTodoCollectionRequest) {

    Assertion.isNotNull(fetchTodoCollectionRequest, "fetchTodoCollectionRequest is required");

    Paginated<Todo> paginated =
        todoPersistence.findPaginated(
            fetchTodoCollectionRequest.getPageNumber(), fetchTodoCollectionRequest.getPageSize());

    return new FetchTodoCollectionResponse(
        StreamSupport.stream(paginated.getItems().spliterator(), false)
            .map(todoConverter::convertToTodoCollectionRecord)
            .collect(Collectors.toList()),
        paginated.getTotalPages(),
        paginated.getTotalElements(),
        fetchTodoCollectionRequest.getPageNumber(),
        fetchTodoCollectionRequest.getPageSize());
  }
}
