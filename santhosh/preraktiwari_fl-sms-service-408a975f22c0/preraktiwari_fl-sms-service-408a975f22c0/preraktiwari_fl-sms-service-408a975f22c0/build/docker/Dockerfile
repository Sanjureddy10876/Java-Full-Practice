FROM adoptopenjdk/openjdk11:ubi
RUN mkdir -p /opt/app/logs
RUN mkdir -p /./logs/spring-boot-logger.log
RUN touch /./logs/spring-boot-logger.log
RUN chmod -R 777 /opt/app
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.app.service.sms.SmsApplication"]


# Creating and Uploading Docker
# 1.  ./gradlew docker
# 2.  ./gradlew dockerPush
###############---OR---##############
# 1. ./gradlew dockerTagsPush -Pbuildno=1.20