FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME "D:/GIT/sampleFromGitServer/gs-spring-boot-docker/complete"
USER spring:spring
COPY "/build/libs/gs-spring-boot-docker-0.1.0.jar" gs-spring-boot-docker-0.1.0.jar
ENTRYPOINT ["java","-jar","/gs-spring-boot-docker-0.1.0.jar"]
