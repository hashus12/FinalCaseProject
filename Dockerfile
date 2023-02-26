FROM openjdk:17

COPY out/artifacts/finalcaseproject_jar/finalcaseproject.jar finalcaseproject.jar

ENTRYPOINT ["java","-jar","finalcaseproject.jar"]