---
-- ==========================LICENSE_START=================================
-- trinity-demo-java
-- ========================================================================
-- Copyright (C) 2019 Christos Tsakostas, OREGOR LTD
-- ========================================================================
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- 
--      http://www.apache.org/licenses/LICENSE-2.0
-- 
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- ===========================LICENSE_END==================================
---

-- -------------------------------------------------------------------------------------------------
-- TASK
-- -------------------------------------------------------------------------------------------------

CREATE TABLE `dmo_task` (
  `root_id` BINARY(16) NOT NULL, 
  `description` VARCHAR(100), 
  `done` BIT(1), 
  `version` INTEGER(11) NOT NULL,
  PRIMARY KEY (`root_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -------------------------------------------------------------------------------------------------
-- DOMAIN_MESSAGE
-- -------------------------------------------------------------------------------------------------

CREATE TABLE `dmo_domain_message` (
  `id` BINARY(16) NOT NULL, 
  `root_id` BINARY(16) NOT NULL, 
  `tenant_id` BINARY(16) NOT NULL, 
  `stream_version` INTEGER(11), 
  `message_name` VARCHAR(512), 
  `message_version` INTEGER(11) NOT NULL, 
  `message` LONGTEXT NOT NULL, 
  `principal` VARCHAR(100), 
  `ip_address` VARCHAR(100), 
  `occurred_on` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

