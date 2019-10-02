FROM openjdk:8-jdk-alpine

LABEL MAINTAINER="Miguel Garcia Puyol <miguelpuyol@gmail.com>, ettingshausen <ettingshausen@outlook.com>"

WORKDIR /var/app

ADD target/zkui-*.jar /var/app/zkui.jar
ADD config.cfg /var/app/config.cfg
ADD docker/bootstrap.sh /var/app/bootstrap.sh

ENTRYPOINT ["/var/app/bootstrap.sh"]

EXPOSE 9090
