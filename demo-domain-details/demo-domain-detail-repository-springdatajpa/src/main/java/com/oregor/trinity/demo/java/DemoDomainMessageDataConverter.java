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

package com.oregor.trinity.demo.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oregor.trinity4j.domain.DomainMessageDataConverter;
import org.springframework.stereotype.Component;

/**
 * The type Context domain message data converter.
 *
 * @author PolyGenesis Platform
 */
@Component
public class DemoDomainMessageDataConverter
    extends DomainMessageDataConverter<DemoDomainMessageData> {

  /**
   * Instantiates a new Context domain message data converter.
   *
   * @param objectMapper the object mapper
   */
  public DemoDomainMessageDataConverter(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected String getContext() {
    return "DEMO";
  }
}
