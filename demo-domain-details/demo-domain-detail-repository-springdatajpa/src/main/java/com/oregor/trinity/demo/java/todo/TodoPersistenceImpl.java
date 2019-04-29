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

import com.oregor.trinity.demo.java.DemoDomainMessageData;
import com.oregor.trinity.demo.java.DemoDomainMessageDataConverter;
import com.oregor.trinity.demo.java.DemoDomainMessageDataRepository;
import com.oregor.trinity4j.domain.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Todo Persistence Implementation.
 *
 * @author PolyGenesis Platform
 */
@Repository
public class TodoPersistenceImpl extends AbstractJpaRepository<Todo, TodoId, DemoDomainMessageData>
    implements TodoPersistence {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * The Todo Persistence Implementation.
   *
   * @param repository the repository
   * @param domainMessageDataRepository the domain message data repository
   * @param domainMessageDataConverter the domain message data converter
   */
  public TodoPersistenceImpl(
      TodoRepository repository,
      DemoDomainMessageDataRepository domainMessageDataRepository,
      DemoDomainMessageDataConverter domainMessageDataConverter) {
    super(repository, domainMessageDataRepository, domainMessageDataConverter, TodoId.class);
  }
}
