FROM openjdk:8-jdk-alpine

MAINTAINER Miguel Garcia Puyol <miguelpuyol@gmail.com>

WORKDIR /var/app

ADD zkui-*.jar /var/app/zkui.jar
ADD config.cfg /var/app/config.cfg
ADD bootstrap.sh /var/app/bootstrap.sh

ENTRYPOINT ["/var/app/bootstrap.sh"]

EXPOSE 9090
