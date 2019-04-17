spring-config:
  activemq:
    broker-url: vm://localhost
    user:
    password:
    in-memory: true
    pool:
      enabled: true
      max-connections: 10
  datasource:
    url: jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=true;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS \"public\";
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    properties:
      hibernate:
        dialect: com.oregor.ddd4j.domain.hibernate.CustomH2Dialect
