FROM openjdk:8-jdk-alpine
COPY target/Fibonacci-1.0.jar .
ENTRYPOINT ["java","-jar","/Fibonacci.jar"]