FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/dependency
COPY ./*.jar app.jar
RUN jar -xf ./app.jar

FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","uk.gov.ipo.feecalculations.rules.Application"]
