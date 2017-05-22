FROM java:8
VOLUME /tmp
ADD anagram-1.0.0-SNAPSHOT.jar anagram-1.0.0-SNAPSHOT.jar
RUN bash -c 'touch /anagram-1.0.0-SNAPSHOT.jar'
ENV JAVA_OPTS=""
EXPOSE 8090
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /anagram-1.0.0-SNAPSHOT.jar" ]
