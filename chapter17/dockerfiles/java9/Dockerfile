FROM registry.cn-shanghai.aliyuncs.com/springcloud-book/alpine-3.10:glibc-2.30-r0
MAINTAINER inwsy@hotmail.com
RUN echo -e "https://mirror.tuna.tsinghua.edu.cn/alpine/v3.10/main\n\
https://mirror.tuna.tsinghua.edu.cn/alpine/v3.10/community" > /etc/apk/repositories

RUN apk --update add curl bash openjdk9-jre && \
      rm -rf /var/cache/apk/*

ENV JAVA_HOME /usr/lib/jvm/default-jvm
ENV PATH ${PATH}:${JAVA_HOME}/bin