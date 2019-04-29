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
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the Task Service.
 *
 * @author PolyGenesis Platform
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

  private TaskPersistence taskPersistence;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Task Service Impl.
   *
   * @param taskPersistence the task persistence
   */
  public TaskServiceImpl(TaskPersistence taskPersistence) {
    this.taskPersistence = taskPersistence;
  }

  // ===============================================================================================
  // ANY
  // ===============================================================================================

  /**
   * Create.
   *
   * @param createTaskRequest the create task request
   * @return create task response
   */
  @Override
  public CreateTaskResponse create(CreateTaskRequest createTaskRequest) {

    Assertion.isNotNull(createTaskRequest, "createTaskRequest is required");

    Task task =
        new Task(
            taskPersistence.nextId(),
            createTaskRequest.getDescription(),
            createTaskRequest.getDone());

    taskPersistence.store(task);

    return new CreateTaskResponse(task.getId().getRootId().toString());
  }

  /**
   * Modify.
   *
   * @param modifyTaskRequest the modify task request
   * @return modify task response
   */
  @Override
  public ModifyTaskResponse modify(ModifyTaskRequest modifyTaskRequest) {

    Assertion.isNotNull(modifyTaskRequest, "modifyTaskRequest is required");

    Task task =
        taskPersistence
            .restore(new TaskId(UUID.fromString(modifyTaskRequest.getTaskId())))
            .orElseThrow(() -> new IllegalArgumentException("Cannot restore task"));

    taskPersistence.store(task);

    return new ModifyTaskResponse(task.getId().getRootId().toString());
  }
}
