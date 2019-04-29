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

/**
 * Queries contract for Todos.
 *
 * @author PolyGenesis Platform
 */
public interface TodoQueryService {

  // ===============================================================================================
  // METHODS
  // ===============================================================================================

  /**
   * Fetch.
   *
   * @param fetchTodoRequest the fetch todo request
   * @return fetch todo response
   */
  FetchTodoResponse fetch(FetchTodoRequest fetchTodoRequest);

  /**
   * Fetch Collection.
   *
   * @param fetchTodoCollectionRequest the fetch todo collection request
   * @return fetch todo collection response
   */
  FetchTodoCollectionResponse fetchCollection(
      FetchTodoCollectionRequest fetchTodoCollectionRequest);
}
