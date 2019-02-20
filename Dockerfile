FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
COPY build/libs/*.jar gorm-test.jar
CMD java ${JAVA_OPTS} -jar gorm-test.jar
