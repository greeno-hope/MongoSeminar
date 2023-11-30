FROM openjdk:17

LABEL maintainer="Mark Greenwood <mgreenwood@sis.tv>"
COPY target/MongoSeminar-*.jar /usr/src/myapp/MongoSeminar.jar
WORKDIR /usr/src/myapp

HEALTHCHECK --interval=30s --timeout=10s --start-period=15m \
 CMD wget --quiet --tries=3 --spider http://localhost:8082/health || exit 1

EXPOSE 8082

ENV MINMEM=256M MAXMEM=756M
USER nobody
CMD java -Xmx${MAXMEM} -Xms${MINMEM} -Dspring.profiles.active=deploy -jar MongoSeminar.jar --debug --trace
