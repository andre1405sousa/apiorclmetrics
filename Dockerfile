FROM openjdk:11
VOLUME [ "/tmp" ]
ADD target/apiorclmetrics-0.0.1-SNAPSHOT.jar apiorclmetrics.jar
ENTRYPOINT [ "java", "-jar", "/apiorclmetrics.jar" ]