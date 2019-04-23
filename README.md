# Demo microservice application structured according to the Trinity Architecture

To learn more about the Trinity Architecture go to: https://medium.com/oregor

To scaffold your own project in java go to: https://github.com/oregor-projects/trinity-scaffolder-java


## Getting started

Follow the steps below to execute the application:

```bash
git clone https://github.com/oregor-projects/trinity-demo-java.git
cd trinity-demo-java
./mvnw package
java -jar -Dspring.profiles.active=ci ./demo-app/target/demo-app.jar 
```

By executing

```bash
curl -X GET http://localhost:8080/actuator/health
```

you should receive:

```bash
{"status":"UP"}
```
