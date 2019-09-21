# Docker 容器启动命令：

```
docker run -p 8080:8080 --rm \
-e JAVA_OPTS='-server -Xmx1g' \
-e PROFILE='default' \
-e EUREKA_SERVER1_HOST=192.168.0.128 \
-e EUREKA_SERVER1_PORT=8761 \
-e EUREKA_SERVER2_HOST=192.168.0.128 \
-e EUREKA_SERVER2_PORT=8762 \
registry.cn-shanghai.aliyuncs.com/springcloud-book/spring-cloud/gateway_server:0.0.1-SNAPSHOT
```

# Docker 镜像下载命令

```
docker pull registry.cn-shanghai.aliyuncs.com/springcloud-book/gateway_server:0.0.1-SNAPSHOT
```