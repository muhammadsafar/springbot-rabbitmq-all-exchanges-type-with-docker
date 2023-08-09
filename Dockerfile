FROM eclipse-temurin:17

#eclipse-temurin is jdk

LABEL mentainer="muhammac.ict1487@gmail.com"

WORKDIR /app/

COPY target/springboot-rabbitmq-demo-0.0.1-SNAPSHOT.jar /app/springboot-rabbitmq-demo.jar

ENTRYPOINT ["java", "-jar", "springboot-rabbitmq-demo.jar"]