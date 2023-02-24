FROM openjdk AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR FinalCaseProject
COPY --from=build target/*.jar FinalCaseProject.jar
ENTRYPOINT ["java", "-jar","FinalCaseProject.jar"]