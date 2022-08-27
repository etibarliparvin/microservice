FROM alpine:3.14
RUN apk add --no-cache openjdk11
COPY build/libs/ms10-demo1-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT ["java"]
CMD ["-jar /app/ms10-demo1-0.0.1-SNAPSHOT.jar"]
