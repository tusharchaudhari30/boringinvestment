FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/personalfin-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]