FROM eclipse-temurin:17.0.9_9-jre
EXPOSE 8080

WORKDIR /home
VOLUME /tmp
ADD springboot.jar /home/springboot.jar
ENTRYPOINT ["java", "-jar", "/home/springboot.jar"]