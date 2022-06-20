FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring

RUN mkdir -p /data
RUN chown spring /data

USER spring:spring
ARG JAR_FILE=target/*.jar
WORKDIR /data
COPY ${JAR_FILE} /data/app.jar
CMD ["java", "-jar", "/data/app.jar"]