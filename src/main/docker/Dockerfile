FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp

ENV MYSQL_HOST **None**
ENV MYSQL_PORT 3306
ENV MYSQL_USER **None**
ENV MYSQL_PASSWORD **None**
ENV MYSQL_DATABASE **None**

ADD 17high-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "sleep 15 && java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]