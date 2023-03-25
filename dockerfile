FROM amazoncorretto:17
EXPOSE 8080
EXPOSE 5000
COPY --chown=1001 build/quarkus-app/lib/ /deployments/lib/
COPY --chown=1001 build/quarkus-app/*.jar /deployments/
COPY --chown=1001 build/quarkus-app/app/ /deployments/app/
COPY --chown=1001 build/quarkus-app/quarkus/ /deployments/quarkus/
ENTRYPOINT ["java","-Dquarkus.http.port=$PORT","-jar","/deployments/quarkus-run.jar"]