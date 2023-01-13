MAINTAINER YUKI.N
FROM java:8
VOLUME /tmp
ADD target/standard-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]