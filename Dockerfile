FROM openjdk:17
EXPOSE 8080
ADD target/book-api-docker.jar book-api-docker.jar
ENTRYPOINT [ "java","-jar","/book-api-docker.jar" ]