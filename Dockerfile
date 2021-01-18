FROM openjdk:8
EXPOSE 8080
COPY /target/ers.war ers.war
CMD java -jar ers.war
