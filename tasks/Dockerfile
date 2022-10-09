FROM bellsoft/liberica-openjdk-alpine-musl:17
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ADD ./ $PROJECT_DIR/
RUN ./mvnw package -DskipTests

FROM bellsoft/liberica-openjdk-alpine-musl:17
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/tasks-1.0.jar $PROJECT_DIR/
EXPOSE 8003
CMD ["java", "-jar", "/opt/project/tasks-1.0.jar"]