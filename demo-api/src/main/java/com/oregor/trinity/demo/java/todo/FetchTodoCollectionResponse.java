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

import com.oregor.trinity4j.api.ApiPagedCollectionResponse;
import java.util.List;

/**
 * The Fetch Todo Collection Response.
 *
 * @author PolyGenesis Platform
 */
public class FetchTodoCollectionResponse extends ApiPagedCollectionResponse<TodoCollectionRecord> {

  private List<TodoCollectionRecord> someArrays;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Fetch Todo Collection Response. */
  @SuppressWarnings("CPD-START")
  public FetchTodoCollectionResponse() {
    super();
  }

  /**
   * Instantiates a new Fetch Todo Collection Response.
   *
   * @param someArrays the some arrays
   */
  public FetchTodoCollectionResponse(List<TodoCollectionRecord> someArrays) {
    setSomeArrays(someArrays);
  }

  /**
   * Instantiates a new Fetch Todo Collection Response.
   *
   * @param items the items
   * @param totalPages the total pages
   * @param totalElements the total elements
   * @param pageNumber the page number
   * @param pageSize the page size
   */
  public FetchTodoCollectionResponse(
      List<TodoCollectionRecord> items,
      Integer totalPages,
      Long totalElements,
      Integer pageNumber,
      Integer pageSize) {
    super(items, totalPages, totalElements, pageNumber, pageSize);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets the Some Arrays.
   *
   * @return list< todo collection record>
   */
  public List<TodoCollectionRecord> getSomeArrays() {
    return this.someArrays;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets the Some Arrays.
   *
   * @param someArrays the some arrays
   */
  @SuppressWarnings("CPD-END")
  public void setSomeArrays(List<TodoCollectionRecord> someArrays) {
    this.someArrays = someArrays;
  }
}
