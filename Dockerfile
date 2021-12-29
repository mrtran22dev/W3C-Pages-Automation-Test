# use OpenJDK 8 image as base image
FROM maven:3.8.4-jdk-8

# copy app files from host (path left) to image file (path right)
RUN mkdir /automation-test
COPY pom.xml /automation-test
RUN mkdir /automation-test/src
COPY src /automation-test/src

# set dir executing future commands
WORKDIR /automation-test

# Run
#CMD mvn clean install
CMD mvn clean test