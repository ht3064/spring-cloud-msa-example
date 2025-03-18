FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} eureka-service.jar
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]