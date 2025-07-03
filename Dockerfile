# 使用官方的 OpenJDK 17 运行时作为基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 JAR 文件到容器中
COPY target/jetbrains-license-1.0.1.jar app.jar

# 创建证书目录
RUN mkdir -p /app/src/main/resources/cert

# 暴露端口
EXPOSE 8081

# 设置 JVM 参数
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# 运行应用
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

# 添加健康检查
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8081/actuator/health || exit 1
