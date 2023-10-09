FROM openjdk:11

WORKDIR /ipl-springboot-backend/

COPY /target/ipldashboard-0.0.1-SNAPSHOT.jar /ipl-springboot-backend/

CMD ["java", "-jar", "ipldashboard-0.0.1-SNAPSHOT.jar"]


