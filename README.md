# JetBrains License Generator v2.0.0

<div align="center">

![License](https://img.shields.io/badge/license-Educational%20Use%20Only-red.svg)
![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.1-green.svg)
![Maven](https://img.shields.io/badge/Maven-3.6+-orange.svg)

**⚠️ 以下仅供学习交流使用，禁止其它用途！！！ ⚠️**

</div>

## 📋 项目简介

JetBrains License Generator 是一个基于 Spring Boot 3.x 的现代化许可证生成工具，支持通过 Web 界面动态配置和生成 JetBrains 系列产品的许可证。

### ✨ 主要特性

- 🌐 **现代化 Web 界面** - 基于 Bootstrap 5 的响应式设计
- ⚙️ **动态配置管理** - 支持通过 Web 界面或配置文件动态调整参数
- 🎯 **多产品支持** - 支持 IDEA、WebStorm、PyCharm、GoLand 等全系列产品
- 🔧 **Spring Boot 3.x** - 采用最新的 Spring Boot 框架
- 📱 **移动端友好** - 响应式设计，支持移动设备访问
- 🔒 **参数验证** - 完整的输入验证和错误处理
- 📊 **实时反馈** - Ajax 异步操作，实时显示生成结果

### 🎯 支持的产品

| 产品 | 代码 | 说明 |
|------|------|------|
| IntelliJ IDEA | II, PSI, PCWMP | Java 开发 IDE |
| WebStorm | WS, PSI, PCWMP | Web 开发 IDE |
| PyCharm | PC, PSI, PCWMP | Python 开发 IDE |
| GoLand | GO, PSI, PCWMP | Go 开发 IDE |
| CLion | CL, PSI, PCWMP | C/C++ 开发 IDE |
| PhpStorm | PS, PSI, PCWMP | PHP 开发 IDE |
| Rider | RD, PSI, PCWMP | .NET 开发 IDE |
| DataGrip | DG, PSI, PCWMP | 数据库工具 |
| RubyMine | RM, PSI, PCWMP | Ruby 开发 IDE |

## 🚀 快速开始

### 环境要求

- Java 17 或更高版本
- Maven 3.6 或更高版本
- 操作系统：Windows、macOS、Linux

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/your-repo/jetbrains-license.git
cd jetbrains-license
```

2. **编译项目**
```bash
mvn clean package -DskipTests
```

3. **运行应用**
```bash
# 方式一：直接运行 Spring Boot 应用
java -jar target/jetbrains-license-1.0.1.jar

# 方式二：使用 Maven 运行
mvn spring-boot:run
```

4. **访问 Web 界面**
```
打开浏览器访问：http://localhost:8081
```

## 🎮 使用方法

### Web 界面方式（推荐）

1. **启动应用**
   ```bash
   java -jar target/jetbrains-license-1.0.1.jar --server.port=8081
   ```

2. **配置参数**
   - 访问 http://localhost:8081/config
   - 设置证书持有者名称、有效期等参数
   - 选择目标产品类型

3. **生成许可证**
   - 返回首页 http://localhost:8081
   - 点击"生成许可证"按钮
   - 复制生成的许可证代码

### 命令行方式（兼容旧版本）

```bash
# 编译项目
mvn clean package -DskipTests

# 运行传统方式
java -cp target/jetbrains-license-1.0.1.jar com.cactusli.license.JetbrainsLicense
```

## ⚙️ 配置说明

### 应用配置文件

在 `src/main/resources/application.yml` 中可以配置默认参数：

```yaml
jetbrains:
  license:
    cert-path: ${user.dir}/src/main/resources/cert
    licensee-name: CactusLi
    license-years: 10
    issuer-name: JetProfile CA
    subject-name: Novice-from-2024-01-19
    product-type: IDEA
```

### 动态配置参数

| 参数 | 说明 | 默认值 |
|------|------|--------|
| 证书持有者名称 | 许可证持有者的名称 | CactusLi |
| 许可证有效期 | 许可证有效年数 | 10年 |
| 证书颁发者 | 证书的颁发机构 | JetProfile CA |
| 证书主题 | 证书的主题信息 | Novice-from-2024-01-19 |
| 产品类型 | 目标产品类型 | IDEA |
| 证书路径 | 证书文件存放路径 | ./src/main/resources/cert |

## 🔧 激活方法

### 方法一：使用 ja-netfilter（推荐）

1. **下载 ja-netfilter**
   - 从项目的 `doc/jetbra` 目录获取 ja-netfilter 工具

2. **配置 JVM 参数**
   - 找到 JetBrains IDE 安装目录下的 `bin` 文件夹
   - 编辑对应的 `.vmoptions` 文件（如 `idea64.exe.vmoptions`）
   - 添加以下参数：
   ```
   --add-opens=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED
   --add-opens=java.base/jdk.internal.org.objectweb.asm.tree=ALL-UNNAMED
   -javaagent:C:\path\to\ja-netfilter.jar=jetbrains
   ```

3. **生成并使用许可证**
   - 使用本工具生成许可证
   - 启动 JetBrains IDE
   - 在激活界面输入生成的许可证

### 方法二：Agent 方式

1. **编译 Agent JAR**
   ```bash
   mvn clean package -DskipTests
   ```

2. **使用 Agent 启动 IDE**
   ```bash
   java -javaagent:target/jetbrains-license-agent-jar-with-dependencies.jar -jar your-jetbrains-ide.jar
   ```

## 📁 项目结构

```
jetbrains-license/
├── src/main/java/
│   └── com/cactusli/license/
│       ├── JetbrainsLicenseApplication.java    # Spring Boot 主应用
│       ├── JetbrainsLicense.java               # 传统命令行入口（已废弃）
│       ├── config/
│       │   └── LicenseConfig.java              # 配置类
│       ├── controller/
│       │   └── LicenseController.java          # Web 控制器
│       ├── service/
│       │   └── LicenseService.java             # 业务服务
│       ├── generator/
│       │   ├── CertificateGenerator.java       # 证书生成器
│       │   ├── LicenseGenerator.java           # 许可证生成器
│       │   └── PowerConfRuleGenerator.java     # 规则生成器
│       ├── domain/
│       │   ├── LicensePart.java                # 许可证实体
│       │   └── Product.java                    # 产品实体
│       ├── constant/
│       │   └── Constant.java                   # 常量定义
│       └── bytecodes/
│           ├── BigIntegerAdvice.java           # 字节码增强
│           └── HttpClientAdvice.java           # HTTP 拦截
├── src/main/resources/
│   ├── templates/                              # Thymeleaf 模板
│   │   ├── index.html                          # 首页
│   │   └── config.html                         # 配置页
│   ├── application.yml                         # 应用配置
│   └── cert/                                   # 证书存放目录
├── doc/                                        # 文档和工具
└── pom.xml                                     # Maven 配置
```

## 🌟 新版本特性

### v2.0.0 更新内容

- ✅ **升级到 Spring Boot 3.x** - 使用最新的 Spring Boot 框架
- ✅ **现代化 Web 界面** - 全新的响应式设计
- ✅ **动态配置管理** - 支持运行时修改配置参数
- ✅ **多产品快速切换** - 一键切换不同 JetBrains 产品
- ✅ **参数验证** - 完整的输入验证和错误提示
- ✅ **实时生成** - Ajax 异步生成，无需刷新页面
- ✅ **移动端支持** - 响应式设计，支持手机和平板访问
- ✅ **向后兼容** - 保持对旧版本命令行方式的支持

## 🔍 API 接口

### REST API 端点

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/` | 首页 |
| GET | `/config` | 配置页面 |
| POST | `/config` | 更新配置 |
| POST | `/generate` | 生成许可证 |
| POST | `/generate/{productType}` | 生成指定产品许可证 |
| POST | `/reset` | 重置配置 |
| GET | `/api/config` | 获取当前配置（JSON） |

### 示例请求

```bash
# 获取当前配置
curl -X GET http://localhost:8080/api/config

# 生成 IDEA 许可证
curl -X POST http://localhost:8080/generate/IDEA

# 生成默认许可证
curl -X POST http://localhost:8080/generate
```

## 🛠️ 开发指南

### 本地开发

1. **克隆项目**
   ```bash
   git clone https://github.com/your-repo/jetbrains-license.git
   cd jetbrains-license
   ```

2. **启动开发服务器**
   ```bash
   mvn spring-boot:run
   ```

3. **访问开发环境**
   ```
   http://localhost:8080
   ```

### 构建部署

1. **构建生产版本**
   ```bash
   mvn clean package -DskipTests
   ```

2. **运行生产版本**
   ```bash
   java -jar target/jetbrains-license-1.0.1.jar
   ```

3. **Docker 部署**
   ```bash
   # 构建镜像
   docker build -t jetbrains-license:2.0.0 .

   # 运行容器
   docker run -p 8080:8080 jetbrains-license:2.0.0
   ```

## ⚠️ 注意事项

1. **仅供学习使用** - 本工具仅用于学习和研究目的，请勿用于商业用途
2. **证书路径** - 确保证书存放路径具有读写权限
3. **Java 版本** - 需要 Java 17 或更高版本
4. **网络环境** - 某些功能可能需要网络连接
5. **安全提醒** - 请在安全的环境中使用，避免泄露敏感信息

## 📄 许可证

本项目仅供学习交流使用，禁止用于商业用途。使用本工具产生的任何后果由使用者自行承担。

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进这个项目。

## 📞 联系方式

- 作者：CactusLi
- 版本：v2.0.0
- 更新时间：2024-12-02

---

**⚠️ 再次提醒：本工具仅供学习交流使用，请勿用于其他用途！**
