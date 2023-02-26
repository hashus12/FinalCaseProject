FROM openjdk:17

COPY FinalCaseProject.jar finalcaseproject.jar

ENTRYPOINT ["java","-jar","finalcaseproject.jar"]