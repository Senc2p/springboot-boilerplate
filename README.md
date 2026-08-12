# Layered Jars
1. For this to work, layers configuration needs to be enabled for spring-boot-maven-plugin.
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
    <layers>
    <enabled>true</enabled>
    </layers>
    </configuration>
</plugin>
```
2. Build the fat jar by running the following command. This will generate a fat jar in the target directory.
```
$ mvn package
```
3. Check layers by running the following command. Note that this is my jar file name. 
   Replace spring-boot-docker-test-0.0.1-SNAPSHOT.jar to the jar name inside your target directory.
```
$ java -Djarmode=tools -jar ./target/springboot-boilerplate-0.0.1-SNAPSHOT.jar list-layers
```
dependencies
spring-boot-loader
snapshot-dependencies
application
4. Copying each layer from the previous step is specified in the Dockerfile. 
   IMPORTANT : The order of COPY instruction needs to match the layers order.
```
FROM amazoncorretto:17 AS JAR_EXTRACT
WORKDIR /app
ARG JAR_FILE=*.jar
COPY ./target/${JAR_FILE} ./app.jar
RUN java -Djarmode=layertools -jar ./app.jar extract
FROM amazoncorretto:17
WORKDIR /application
COPY --from=JAR_EXTRACT /app/dependencies ./
COPY --from=JAR_EXTRACT /app/spring-boot-loader ./
COPY --from=JAR_EXTRACT /app/snapshot-dependencies ./
COPY --from=JAR_EXTRACT /app/application ./
EXPOSE 8085
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
```
# Buildpacks
Docker images can be built by running this command.
```
$ mvn spring-boot:build-image
```
1. To start the image with Docker after the build:
```
docker run --rm -p 8085:8085 --name springboot-boilerplate docker.io/library/springboot-boilerplate:0.0.1-SNAPSHOT
```
2. To access the endpoint hit the following URL in your browser:
```
http://localhost:8085/books
```
