FROM maven:3.8-openjdk-17-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -U

FROM openjdk:17-slim

COPY --from=build /app/target/mars-mission.jar /usr/local/lib/mars-mission.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/mars-mission.jar"]
