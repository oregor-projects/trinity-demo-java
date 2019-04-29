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
 * The Spring REST Controller for Task Services.
 *
 * @author PolyGenesis Platform
 */
@RestController
@RequestMapping(RestConstants.CONTEXT_REQUEST_MAPPING)
public class TaskRestService extends AbstractRestController {

  private TaskService taskService;
  private TaskQueryService taskQueryService;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Task.
   *
   * @param taskService the task service
   * @param taskQueryService the task query service
   */
  public TaskRestService(TaskService taskService, TaskQueryService taskQueryService) {
    this.taskService = taskService;
    this.taskQueryService = taskQueryService;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * REST Endpoint for Create.
   *
   * @param createTaskRequest the create task request
   * @param httpServletRequest the http servlet request
   * @return create task response
   */
  @PostMapping({"/tasks"})
  public CreateTaskResponse create(
      @RequestBody CreateTaskRequest createTaskRequest, HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(createTaskRequest, "createTaskRequest is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    createTaskRequest.setTenantId(getTenantId(httpServletRequest));
    createTaskRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return taskService.create(createTaskRequest);
  }

  /**
   * REST Endpoint for Modify.
   *
   * @param taskId the task id
   * @param modifyTaskRequest the modify task request
   * @param httpServletRequest the http servlet request
   * @return modify task response
   */
  @PutMapping({"/tasks/{taskId}/modify"})
  public ModifyTaskResponse modify(
      @PathVariable("taskId") String taskId,
      @RequestBody ModifyTaskRequest modifyTaskRequest,
      HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(taskId, "taskId is required");
    Assertion.isNotNull(modifyTaskRequest, "modifyTaskRequest is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    modifyTaskRequest.setTaskId(taskId);
    modifyTaskRequest.setTenantId(getTenantId(httpServletRequest));
    modifyTaskRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return taskService.modify(modifyTaskRequest);
  }

  /**
   * REST Endpoint for Fetch.
   *
   * @param taskId the task id
   * @param httpServletRequest the http servlet request
   * @return fetch task response
   */
  @GetMapping({"/tasks/{taskId}"})
  public FetchTaskResponse fetch(
      @PathVariable("taskId") String taskId, HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(taskId, "taskId is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    FetchTaskRequest fetchTaskRequest = new FetchTaskRequest();
    fetchTaskRequest.setTaskId(taskId);
    fetchTaskRequest.setTenantId(getTenantId(httpServletRequest));
    fetchTaskRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return taskQueryService.fetch(fetchTaskRequest);
  }

  /**
   * REST Endpoint for Fetch Collection.
   *
   * @param pageNumber the page number
   * @param pageSize the page size
   * @param query the query
   * @param httpServletRequest the http servlet request
   * @return fetch task collection response
   */
  @GetMapping({"/tasks"})
  public FetchTaskCollectionResponse fetchCollection(
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "") String query,
      HttpServletRequest httpServletRequest) {

    Assertion.isNotNull(pageNumber, "pageNumber is required");
    Assertion.isNotNull(pageSize, "pageSize is required");
    Assertion.isNotNull(query, "query is required");
    Assertion.isNotNull(httpServletRequest, "httpServletRequest is required");

    FetchTaskCollectionRequest fetchTaskCollectionRequest = new FetchTaskCollectionRequest();
    fetchTaskCollectionRequest.setPageNumber(pageNumber);
    fetchTaskCollectionRequest.setPageSize(pageSize);
    fetchTaskCollectionRequest.setTenantId(getTenantId(httpServletRequest));
    fetchTaskCollectionRequest.setIpAddress(getRemoteIpAddress(httpServletRequest));

    return taskQueryService.fetchCollection(fetchTaskCollectionRequest);
  }
}
