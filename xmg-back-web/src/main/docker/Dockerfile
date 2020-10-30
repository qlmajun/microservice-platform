FROM anapsix/alpine-java:8
MAINTAINER warrior "mj_warrior@163.com"
RUN mkdir -p /app
WORKDIR /app
ADD nledu-soft-sell-web.jar .
EXPOSE 9090
ENTRYPOINT ["sh","-c","java -Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar nledu-soft-sell-web.jar"]