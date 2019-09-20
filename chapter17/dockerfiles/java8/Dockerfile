FROM registry.cn-shanghai.aliyuncs.com/springcloud-book/alpine-3.10:glibc-2.30-r0
MAINTAINER inwsy@hotmail.com
ADD server-jre-8u221-linux-x64.tar.gz /opt/
RUN chmod +x /opt/jdk1.8.0_221
ENV JAVA_HOME=/opt/jdk1.8.0_221
ENV PATH="$JAVA_HOME/bin:${PATH}"