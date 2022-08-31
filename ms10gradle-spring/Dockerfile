FROM alpine:3.11.2
RUN apk add --no-cache openjdk11
COPY build/libs/ms10gradle-spring-0.0.1-SNAPSHOT.350cc68.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/ms10gradle-spring-0.0.1-SNAPSHOT.350cc68.jar"]
