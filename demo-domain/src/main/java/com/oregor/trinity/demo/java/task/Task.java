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

import com.oregor.trinity.demo.java.Constants;
import com.oregor.trinity4j.commons.assertion.Assertion;
import com.oregor.trinity4j.domain.AggregateRoot;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Task Aggregate Root.
 *
 * @author PolyGenesis Platform
 */
@Entity
@Table(name = Constants.DEFAULT_TABLE_PREFIX + "task")
public class Task extends AggregateRoot<TaskId> {

  private String description;
  private Boolean done;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** No-args constructor for persistence frameworks. */
  protected Task() {
    super();
  }

  /**
   * Instantiates a new Task.
   *
   * @param taskId the task id
   * @param description the description
   * @param done the done
   */
  public Task(TaskId taskId, String description, Boolean done) {
    super(taskId);
    setDescription(description);
    setDone(done);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets the Description.
   *
   * @return string
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets the Done.
   *
   * @return boolean
   */
  public Boolean getDone() {
    return this.done;
  }

  // ===============================================================================================
  // GUARDS
  // ===============================================================================================

  /**
   * Sets the Description.
   *
   * @param description the description
   */
  private void setDescription(String description) {
    Assertion.isNotNull(description, "Description is required");

    this.description = description;
  }

  /**
   * Sets the Done.
   *
   * @param done the done
   */
  private void setDone(Boolean done) {
    Assertion.isNotNull(done, "Done is required");

    this.done = done;
  }
}
