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

import com.oregor.trinity.demo.java.RestConstants;
import com.oregor.trinity4j.api.AbstractRestController;
import com.oregor.trinity4j.commons.assertion.Assertion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Spring REST Controller for Todo Services.
 *
 * @author PolyGenesis Platform
 */
@RestController
@RequestMapping(RestConstants.CONTEXT_REQUEST_MAPPING)
public class TodoRestService extends AbstractRestController {

  private TodoService todoService;
  private TodoQueryService todoQueryService;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Todo.
   *
   * @param todoService the todo service
   * @param todoQueryService the todo query service
   */
  public TodoRestService(TodoService todoService, TodoQueryService todoQueryService) {
    this.todoService = todoService;
    this.todoQueryService = todoQueryService;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * REST Endpoint for Create.
   *
   * @param createTodoRequest the create todo request
   * @param httpServletRequest the http servlet request
   * @return create todo response
   */
  @PostMapping({"/todos"})
  public CreateTodoResponse create(
      @RequestBody CreateTodoRequest createTodoRequest, HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(createTodoRequest, "createTodoRequest is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    createTodoRequest.setTenantId(getTenantId(httpServletRequest));
    createTodoRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return todoService.create(createTodoRequest);
  }

  /**
   * REST Endpoint for Modify.
   *
   * @param todoId the todo id
   * @param modifyTodoRequest the modify todo request
   * @param httpServletRequest the http servlet request
   * @return modify todo response
   */
  @PutMapping({"/todos/{todoId}/modify"})
  public ModifyTodoResponse modify(
      @PathVariable("todoId") String todoId,
      @RequestBody ModifyTodoRequest modifyTodoRequest,
      HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(todoId, "todoId is required");
    Assertion.isNotNull(modifyTodoRequest, "modifyTodoRequest is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    modifyTodoRequest.setTodoId(todoId);
    modifyTodoRequest.setTenantId(getTenantId(httpServletRequest));
    modifyTodoRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return todoService.modify(modifyTodoRequest);
  }

  /**
   * REST Endpoint for Fetch.
   *
   * @param todoId the todo id
   * @param httpServletRequest the http servlet request
   * @return fetch todo response
   */
  @GetMapping({"/todos/{todoId}"})
  public FetchTodoResponse fetch(
      @PathVariable("todoId") String todoId, HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(todoId, "todoId is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    FetchTodoRequest fetchTodoRequest = new FetchTodoRequest();
    fetchTodoRequest.setTodoId(todoId);
    fetchTodoRequest.setTenantId(getTenantId(httpServletRequest));
    fetchTodoRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return todoQueryService.fetch(fetchTodoRequest);
  }

  /**
   * REST Endpoint for Fetch Collection.
   *
   * @param pageNumber the page number
   * @param pageSize the page size
   * @param query the query
   * @param httpServletRequest the http servlet request
   * @return fetch todo collection response
   */
  @GetMapping({"/todos"})
  public FetchTodoCollectionResponse fetchCollection(
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "") String query,
      HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(pageNumber, "pageNumber is required");
    Assertion.isNotNull(pageSize, "pageSize is required");
    Assertion.isNotNull(query, "query is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    FetchTodoCollectionRequest fetchTodoCollectionRequest = new FetchTodoCollectionRequest();
    fetchTodoCollectionRequest.setPageNumber(pageNumber);
    fetchTodoCollectionRequest.setPageSize(pageSize);
    fetchTodoCollectionRequest.setTenantId(getTenantId(httpServletRequest));
    fetchTodoCollectionRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return todoQueryService.fetchCollection(fetchTodoCollectionRequest);
  }
}
