FROM bellsoft/liberica-openjdk-alpine:17
LABEL image="tnas/wa-crud-case"
LABEL version="1.0"
LABEL description="WA CRUD Case API"
EXPOSE 8080
WORKDIR /wa-crud-case
COPY build/libs/wa-crud-case-0.0.1-SNAPSHOT.jar .
ENTRYPOINT java -jar ./wa-crud-case-0.0.1-SNAPSHOT.jar