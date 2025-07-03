#!/bin/bash

echo "========================================"
echo " JetBrains License Generator v2.0.0"
echo " Spring Boot 3.x Application"
echo "========================================"
echo

echo "正在启动应用..."
echo "请稍等片刻..."
echo

java -jar target/jetbrains-license-1.0.1.jar --server.port=8081

echo
echo "应用已停止"
