FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD build/libs/AuthService-0.0.1-SNAPSHOT.jar authserviceapp.jar
CMD ["java", "-jar", "authserviceapp.jar"]