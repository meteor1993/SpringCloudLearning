# Docker 容器启动命令：

```
docker run -p 8761:8080 --rm \
-e JAVA_OPTS='-server -Xmx1g' \
-e PROFILE='default' \
-e EUREKA_SERVER_HOST=192.168.0.128 \
-e EUREKA_SERVER_PORT=8762 \
registry.cn-shanghai.aliyuncs.com/springcloud-book/eureka_server:0.0.1-SNAPSHOT
```

```
docker run -p 8762:8080 --rm \
-e JAVA_OPTS='-server -Xmx1g' \
-e PROFILE='default' \
-e EUREKA_SERVER_HOST=192.168.0.128 \
-e EUREKA_SERVER_PORT=8761 \
registry.cn-shanghai.aliyuncs.com/springcloud-book/eureka_server:0.0.1-SNAPSHOT
```

# Docker 镜像下载命令

```
docker pull registry.cn-shanghai.aliyuncs.com/springcloud-book/eureka_server:0.0.1-SNAPSHOT
```