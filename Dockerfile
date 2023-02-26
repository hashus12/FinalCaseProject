FROM openjdk:17

COPY finalcaseproject.jar finalcaseproject.jar

ENTRYPOINT ["java","-jar","finalcaseproject.jar"]