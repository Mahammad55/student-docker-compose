FROM openjdk:17
COPY build/libs/student-docker-compose-0.0.1-SNAPSHOT.jar /app/
CMD  ["java","-jar","/app/student-docker-compose-0.0.1-SNAPSHOT.jar"]