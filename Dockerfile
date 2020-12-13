FROM openjdk:8-jdk-alpine
COPY Fibonacci.jar .
ENTRYPOINT ["java","-jar","/Fibonacci.jar"]