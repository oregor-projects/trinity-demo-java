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

import com.oregor.trinity4j.commons.assertion.Assertion;
import com.oregor.trinity4j.domain.Paginated;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the Task Query Service.
 *
 * @author PolyGenesis Platform
 */
@Service
@Transactional
public class TaskQueryServiceImpl implements TaskQueryService {

  private TaskPersistence taskPersistence;
  private TaskConverter taskConverter;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Task Query Service Impl.
   *
   * @param taskPersistence the task persistence
   * @param taskConverter the task converter
   */
  public TaskQueryServiceImpl(TaskPersistence taskPersistence, TaskConverter taskConverter) {
    this.taskPersistence = taskPersistence;
    this.taskConverter = taskConverter;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * Fetch.
   *
   * @param fetchTaskRequest the fetch task request
   * @return fetch task response
   */
  @Override
  public FetchTaskResponse fetch(FetchTaskRequest fetchTaskRequest) {

    Assertion.isNotNull(fetchTaskRequest, "fetchTaskRequest is required");

    Task task =
        taskPersistence
            .restore(new TaskId(UUID.fromString(fetchTaskRequest.getTaskId())))
            .orElseThrow(() -> new IllegalArgumentException("Cannot restore task"));

    return new FetchTaskResponse(task.getDescription(), task.getDone());
  }

  /**
   * Fetch Collection.
   *
   * @param fetchTaskCollectionRequest the fetch task collection request
   * @return fetch task collection response
   */
  @Override
  public FetchTaskCollectionResponse fetchCollection(
      FetchTaskCollectionRequest fetchTaskCollectionRequest) {

    Assertion.isNotNull(fetchTaskCollectionRequest, "fetchTaskCollectionRequest is required");

    Paginated<Task> paginated =
        taskPersistence.findPaginated(
            fetchTaskCollectionRequest.getPageNumber(), fetchTaskCollectionRequest.getPageSize());

    return new FetchTaskCollectionResponse(
        StreamSupport.stream(paginated.getItems().spliterator(), false)
            .map(taskConverter::convertToTaskCollectionRecord)
            .collect(Collectors.toList()),
        paginated.getTotalPages(),
        paginated.getTotalElements(),
        fetchTaskCollectionRequest.getPageNumber(),
        fetchTaskCollectionRequest.getPageSize());
  }
}
