FROM adoptopenjdk/openjdk16:jre-16_36
VOLUME /tmp
COPY target/*.jar link-converter.jar
ENTRYPOINT ["java","-Dspring.profiles.active=doc","-jar","/link-converter.jar"]