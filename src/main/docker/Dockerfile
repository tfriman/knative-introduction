####
# This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode
#
# Before building the container image run:
#
# mvn package
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.jvm -t quarkus/rfe600-cookielogger-jvm .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/rfe600-cookielogger-jvm
#
# If you want to include the debug port into your docker image
# you will have to expose the debug port (default 5005) like this :  EXPOSE 8080 5050
# 
# Then run the container using : 
#
# docker run -i --rm -p 8080:8080 -p 5005:5005 -e JAVA_ENABLE_DEBUG="true" quarkus/rfe600-cookielogger-jvm
#
###
FROM registry.access.redhat.com/ubi8/openjdk-11

ARG RUN_JAVA_VERSION=1.3.8

ENV LANG='en_GB.UTF-8' LANGUAGE='en_GB:en'

# Install java and the run-java script
# Also set up permissions for user `1001`
#RUN curl https://repo1.maven.org/maven2/io/fabric8/run-java-sh/${RUN_JAVA_VERSION}/run-java-sh-${RUN_JAVA_VERSION}-sh.sh -o /deployments/run-java.sh \
#    && chown 1001 /deployments/run-java.sh \
#    && chmod 540 /deployments/run-java.sh \
#    && echo "securerandom.source=file:/dev/urandom" >> /etc/alternatives/jre/lib/security/java.security

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar

EXPOSE 8080