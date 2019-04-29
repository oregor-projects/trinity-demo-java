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

import com.oregor.trinity4j.domain.AggregateRootId;
import java.util.UUID;
import javax.persistence.Embeddable;

/**
 * The Task Aggregate Root Id.
 *
 * @author PolyGenesis Platform
 */
@Embeddable
public class TaskId extends AggregateRootId {

  private static final long serialVersionUID = 1L;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** No-args constructor for persistence frameworks. */
  protected TaskId() {
    super();
  }

  /**
   * Instantiates a new Task.
   *
   * @param rootId the root id
   */
  public TaskId(UUID rootId) {
    super(rootId);
  }
}
