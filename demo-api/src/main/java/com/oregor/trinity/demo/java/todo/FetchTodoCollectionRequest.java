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

import com.oregor.trinity4j.api.ApiPagedCollectionRequest;

/**
 * The Fetch Todo Collection Request.
 *
 * @author PolyGenesis Platform
 */
public class FetchTodoCollectionRequest extends ApiPagedCollectionRequest {

  private Integer pageNumber;
  private Integer pageSize;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Fetch Todo Collection Request. */
  @SuppressWarnings("CPD-START")
  public FetchTodoCollectionRequest() {
    super();
  }

  /**
   * Instantiates a new Fetch Todo Collection Request.
   *
   * @param pageNumber the page number
   * @param pageSize the page size
   */
  public FetchTodoCollectionRequest(Integer pageNumber, Integer pageSize) {
    setPageNumber(pageNumber);
    setPageSize(pageSize);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets the Page Number.
   *
   * @return integer
   */
  public Integer getPageNumber() {
    return this.pageNumber;
  }

  /**
   * Gets the Page Size.
   *
   * @return integer
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets the Page Number.
   *
   * @param pageNumber the page number
   */
  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  /**
   * Sets the Page Size.
   *
   * @param pageSize the page size
   */
  @SuppressWarnings("CPD-END")
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
}
