# 🚀 JetBrains License Generator v2.0.0

<div align="center">

![License](https://img.shields.io/badge/license-Educational%20Use%20Only-red.svg)
![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.1-green.svg)
![Maven](https://img.shields.io/badge/Maven-3.6+-orange.svg)
![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-3.0+-06B6D4.svg)
![Version](https://img.shields.io/badge/Version-2.0.0-brightgreen.svg)

**⚠️ For Educational Use Only - 仅供学习交流使用 ⚠️**

*A modern, web-based JetBrains license generator with automated VM configuration*

---

</div>

## 🌟 What's New in v2.0.0

- 🎨 **Modern UI with Tailwind CSS** - Beautiful, responsive design
- 🛠️ **Automated VM Configuration** - One-click setup for all JetBrains IDEs
- 🌐 **Web-Based Interface** - No more command-line complexity
- ⚡ **Real-time Generation** - Instant license creation with Ajax
- 📱 **Mobile Responsive** - Works perfectly on all devices
- 🔧 **Spring Boot 3.x** - Built with the latest technology stack

---

## 📑 Table of Contents

### English Documentation
- [🚀 Quick Start](#-quick-start)
- [📋 Project Overview](#-project-overview)
- [🎯 Supported Products](#-supported-products)
- [🎮 Usage Guide](#-usage-guide)
- [🛠️ VM Options Configuration](#️-vm-options-configuration)
- [⚙️ Configuration](#️-configuration)
- [🔧 Activation Methods](#-activation-methods)
- [📁 Project Structure](#-project-structure)
- [🛠️ Tech Stack](#️-tech-stack)
- [🔍 API Reference](#-api-reference)
- [⚠️ Important Notes](#️-important-notes)

### 中文文档
- [🚀 快速开始](#-快速开始)
- [📋 项目简介](#-项目简介)
- [🎯 支持的产品](#-支持的产品)
- [🎮 使用方法](#-使用方法)
- [🛠️ VM选项配置详解](#️-vm选项配置详解)
- [⚙️ 配置说明](#️-配置说明)
- [🔧 激活方法](#-激活方法)

---

## 🚀 Quick Start

### ⚡ One-Minute Setup

```bash
# 1. Clone and build
git clone https://github.com/your-repo/jetbrains-license.git
cd jetbrains-license
mvn clean package -DskipTests

# 2. Run the application
java -jar target/jetbrains-license-1.0.1.jar

# 3. Open your browser
# Visit: http://localhost:8080
```

### 📋 Step-by-Step Guide

| Step | Action | Description |
|------|--------|-------------|
| 1️⃣ | **Clone & Build** | `mvn clean package -DskipTests` |
| 2️⃣ | **Start Application** | `java -jar target/jetbrains-license-1.0.1.jar` |
| 3️⃣ | **Open Web Interface** | Visit `http://localhost:8080` |
| 4️⃣ | **Configure Parameters** | Go to `/config` page |
| 5️⃣ | **Generate License** | Click "Generate License" on homepage |
| 6️⃣ | **Setup VM Options** | Visit `/vmoptions` for automated setup |
| 7️⃣ | **Activate JetBrains** | Use generated license in your IDE |

## 📋 Project Overview

**JetBrains License Generator** is a cutting-edge, web-based license generation tool built with Spring Boot 3.x. It provides an intuitive interface for generating and managing JetBrains product licenses with automated VM configuration capabilities.

### 🎯 What This Tool Does

This application simplifies the process of:
- **Generating licenses** for all JetBrains IDEs (IDEA, WebStorm, PyCharm, etc.)
- **Automatically configuring** VM options for JetBrains products
- **Managing certificates** and license parameters through a web interface
- **Providing real-time feedback** during the license generation process

### ✨ Key Features

- 🌐 **Modern Web Interface** - Beautiful, responsive design with Tailwind CSS
- 🛠️ **Automated VM Setup** - One-click configuration for all JetBrains IDEs
- ⚙️ **Dynamic Configuration** - Runtime parameter adjustment via web interface
- 🎯 **Universal Support** - Works with all JetBrains products (IDEA, WebStorm, PyCharm, GoLand, etc.)
- 🔧 **Spring Boot 3.x** - Built with the latest enterprise-grade framework
- 📱 **Mobile Responsive** - Perfect experience on desktop, tablet, and mobile
- 🔒 **Input Validation** - Comprehensive validation and error handling
- 📊 **Real-time Feedback** - Ajax-powered instant results
- 🚀 **High Performance** - Optimized for speed and reliability

### 🎯 Supported Products

<table>
<tr>
<th>Product</th>
<th>Code</th>
<th>Description</th>
<th>Product</th>
<th>Code</th>
<th>Description</th>
</tr>
<tr>
<td><b>IntelliJ IDEA</b></td>
<td><code>II, PSI, PCWMP</code></td>
<td>Java Development IDE</td>
<td><b>WebStorm</b></td>
<td><code>WS, PSI, PCWMP</code></td>
<td>Web Development IDE</td>
</tr>
<tr>
<td><b>PyCharm</b></td>
<td><code>PC, PSI, PCWMP</code></td>
<td>Python Development IDE</td>
<td><b>GoLand</b></td>
<td><code>GO, PSI, PCWMP</code></td>
<td>Go Development IDE</td>
</tr>
<tr>
<td><b>CLion</b></td>
<td><code>CL, PSI, PCWMP</code></td>
<td>C/C++ Development IDE</td>
<td><b>PhpStorm</b></td>
<td><code>PS, PSI, PCWMP</code></td>
<td>PHP Development IDE</td>
</tr>
<tr>
<td><b>Rider</b></td>
<td><code>RD, PSI, PCWMP</code></td>
<td>.NET Development IDE</td>
<td><b>DataGrip</b></td>
<td><code>DG, PSI, PCWMP</code></td>
<td>Database Tool</td>
</tr>
<tr>
<td colspan="3"><b>RubyMine</b> - <code>RM, PSI, PCWMP</code> - Ruby Development IDE</td>
<td colspan="3"><b>And more...</b> - All JetBrains products supported</td>
</tr>
</table>

## 🚀 Installation & Setup

### 📋 Prerequisites

| Requirement | Version | Purpose |
|-------------|---------|---------|
| **Java** | 17+ | Runtime environment |
| **Maven** | 3.6+ | Build tool |
| **OS** | Windows/macOS/Linux | Cross-platform support |
| **Browser** | Modern browser | Web interface access |

### 🛠️ Installation Steps

#### Method 1: Quick Start (Recommended)

```bash
# Clone the repository
git clone https://github.com/your-repo/jetbrains-license.git
cd jetbrains-license

# Build and run in one command
mvn clean package -DskipTests && java -jar target/jetbrains-license-1.0.1.jar
```

#### Method 2: Step by Step

```bash
# 1. Clone the project
git clone https://github.com/your-repo/jetbrains-license.git
cd jetbrains-license

# 2. Build the project
mvn clean package -DskipTests

# 3. Run the application
java -jar target/jetbrains-license-1.0.1.jar

# 4. Alternative: Run with Maven
mvn spring-boot:run
```

#### Method 3: Using Batch Script (Windows)

```bash
# Simply run the provided batch file
start.bat
```

### 🌐 Access the Application

Once started, open your browser and visit:
```
http://localhost:8080
```

The application will be ready to use immediately!

## 🎮 Usage Guide

### 🌐 Web Interface (Recommended)

The modern web interface provides the easiest way to generate licenses and configure your JetBrains IDEs.

#### Step 1: Start the Application
```bash
java -jar target/jetbrains-license-1.0.1.jar
```

#### Step 2: Configure License Parameters
1. Open your browser and visit: `http://localhost:8080/config`
2. Set your preferences:
   - **Certificate Holder Name**: Your name or organization
   - **License Validity**: Duration in years (default: 10 years)
   - **Product Type**: Select your target JetBrains product
   - **Other Parameters**: Issuer name, subject name, etc.

#### Step 3: Generate License
1. Return to the homepage: `http://localhost:8080`
2. Click the **"Generate License"** button
3. Copy the generated license code (it will appear instantly)

#### Step 4: Configure VM Options ⭐ **Critical Step**
1. Visit: `http://localhost:8080/vmoptions`
2. Ensure the `doc/jetbra/ja-netfilter.jar` file exists
3. Click **"Configure All Products"** for automatic setup
4. Wait for the configuration to complete

#### Step 5: Activate Your JetBrains IDE
1. **Restart** your JetBrains IDE (IDEA, WebStorm, PyCharm, etc.)
2. In the activation dialog, select **"License Server"** or **"Activation Code"**
3. **Paste** the generated license code
4. Click **"Activate"** to complete the process

### 💻 Command Line (Legacy Support)

For users who prefer command-line interface:

```bash
# Build the project
mvn clean package -DskipTests

# Run in legacy mode
java -cp target/jetbrains-license-1.0.1.jar com.cactusli.license.JetbrainsLicense
```

> **Note**: The web interface is recommended for better user experience and additional features.

## 🛠️ VM Options Configuration

### 🎯 Overview

VM Options Configuration is the core feature of JetBrains License Generator, used to automatically configure JetBrains products' VM options and add ja-netfilter.jar agent, which is the **key step** for activating JetBrains products.

### ✅ Supported Products

| Product | Description | Product | Description |
|---------|-------------|---------|-------------|
| **IntelliJ IDEA** | Java Development IDE | **WebStorm** | JavaScript Development IDE |
| **PyCharm** | Python Development IDE | **GoLand** | Go Development IDE |
| **CLion** | C/C++ Development IDE | **PhpStorm** | PHP Development IDE |
| **Rider** | .NET Development IDE | **DataGrip** | Database Tool |
| **RubyMine** | Ruby Development IDE | **AppCode** | iOS Development IDE |
| **DataSpell** | Data Science IDE | **Gateway** | Remote Development Tool |

### 🚀 Core Features

1. **🔍 Auto Detection** - Detect if ja-netfilter.jar file exists
2. **⚡ Flexible Configuration** - Support configuring all products or specific products
3. **📁 Custom Paths** - Support custom jar paths and vmoptions file paths
4. **🔄 Smart Processing** - Automatically remove old configurations and add new ones
5. **📊 Status Display** - Real-time display of configuration results and product status
6. **🛡️ Error Handling** - Detailed error information and handling suggestions

### 📋 Detailed Usage Steps

#### 1. Preparation
- Ensure `doc/jetbra/ja-netfilter.jar` file exists in the project directory
- Start application: `java -jar target/jetbrains-license-1.0.1.jar --server.port=8080`

#### 2. Access Configuration Page
```
http://localhost:8080/vmoptions
```

#### 3. Configuration Options

**🔧 Basic Configuration**
- **Configure All Products**: Click "Configure All Products" button for one-click configuration of all supported JetBrains products
- **Selective Configuration**: Click product cards to select products to configure, then click "Configure Selected Products"

**📁 Advanced Configuration**
- **Custom jar path**: Check "Use custom jar path", click "Browse" to select ja-netfilter.jar file
- **Custom vmoptions path**: Check "Custom path" in product cards, select corresponding vmoptions file

#### 4. Execute Configuration
1. Choose configuration method as needed
2. Click corresponding configuration button
3. Wait for configuration completion and check results

#### 5. Complete Activation
1. **Restart IDE**: Restart corresponding JetBrains IDE after configuration
2. **Use License**: Use generated license for activation in IDE

## ⚙️ Configuration

### Application Configuration

Configure default parameters in `src/main/resources/application.yml`:

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

### Dynamic Configuration Parameters

| Parameter | Description | Default Value |
|-----------|-------------|---------------|
| Certificate Holder Name | Name of license holder | CactusLi |
| License Validity | License validity in years | 10 years |
| Certificate Issuer | Certificate issuing authority | JetProfile CA |
| Certificate Subject | Certificate subject information | Novice-from-2024-01-19 |
| Product Type | Target product type | IDEA |
| Certificate Path | Certificate file storage path | ./src/main/resources/cert |

## 🔧 Activation Methods

### Method 1: Using ja-netfilter (Recommended)

1. **Download ja-netfilter**
   - Get ja-netfilter tool from project's `doc/jetbra` directory

2. **Configure JVM Parameters**
   - Find `bin` folder in JetBrains IDE installation directory
   - Edit corresponding `.vmoptions` file (e.g., `idea64.exe.vmoptions`)
   - Add the following parameters:
   ```
   --add-opens=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED
   --add-opens=java.base/jdk.internal.org.objectweb.asm.tree=ALL-UNNAMED
   -javaagent:C:\path\to\ja-netfilter.jar=jetbrains
   ```

3. **Generate and Use License**
   - Use this tool to generate license
   - Start JetBrains IDE
   - Enter generated license in activation interface

## 📁 Project Structure

```
jetbrains-license/
├── src/main/java/
│   └── com/cactusli/license/
│       ├── JetbrainsLicenseApplication.java    # Spring Boot Main Application
│       ├── config/
│       │   └── LicenseConfig.java              # Configuration Class
│       ├── controller/
│       │   └── LicenseController.java          # Web Controller
│       ├── service/
│       │   └── LicenseService.java             # Business Service
│       └── generator/
│           ├── CertificateGenerator.java       # Certificate Generator
│           ├── LicenseGenerator.java           # License Generator
│           └── PowerConfRuleGenerator.java     # Rule Generator
├── src/main/resources/
│   ├── templates/                              # Thymeleaf Templates
│   │   ├── index.html                          # Homepage
│   │   ├── config.html                         # Configuration Page
│   │   └── vmoptions-advanced.html             # VM Options Page
│   ├── application.yml                         # Application Configuration
│   └── cert/                                   # Certificate Storage
├── doc/                                        # Documentation and Tools
└── pom.xml                                     # Maven Configuration
```

## 🌟 What's New in v2.0.0

### 🎨 Major UI Overhaul
- **Tailwind CSS Integration** - Migrated from Bootstrap to modern Tailwind CSS
- **Glass Morphism Design** - Beautiful frosted glass effects and gradients
- **Smooth Animations** - Enhanced user experience with fluid transitions
- **Mobile-First Design** - Optimized for all device sizes

### 🚀 Enhanced Functionality
- **Spring Boot 3.x Upgrade** - Latest enterprise-grade framework
- **Automated VM Configuration** - One-click setup for all JetBrains products
- **Real-time License Generation** - Instant results with Ajax technology
- **Dynamic Parameter Management** - Runtime configuration without restarts
- **Multi-Product Support** - Quick switching between different JetBrains IDEs

### 🛠️ Technical Improvements
- **Performance Optimization** - Faster loading and response times
- **Enhanced Validation** - Comprehensive input validation and error handling
- **Improved Error Messages** - Clear, actionable feedback for users
- **Better Code Structure** - Cleaner, more maintainable codebase
- **Backward Compatibility** - Legacy command-line support maintained

## 🛠️ Tech Stack

### Backend Technologies
- **Spring Boot 3.2.1** - Enterprise-grade Java framework
- **Spring Web MVC** - RESTful API and web controllers
- **Thymeleaf** - Server-side template engine
- **Maven** - Project build and dependency management
- **Java 17** - Latest LTS version with modern features
- **BouncyCastle** - Cryptographic operations for certificate generation
- **Hutool** - Utility library for common operations

### Frontend Technologies
- **Tailwind CSS 3.0+** - Modern utility-first CSS framework
- **JavaScript ES6+** - Modern JavaScript features
- **Font Awesome 6.4** - Comprehensive icon library
- **jQuery 3.6** - JavaScript library for Ajax operations
- **Responsive Design** - Mobile-first approach

### Key Dependencies
```xml
<!-- Core Spring Boot -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Cryptography -->
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk18on</artifactId>
    <version>1.74</version>
</dependency>

<!-- Utilities -->
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.25</version>
</dependency>
```

## 🔍 API Reference

### REST API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/` | Homepage |
| GET | `/config` | Configuration page |
| POST | `/config` | Update configuration |
| POST | `/generate` | Generate license |
| POST | `/generate/{productType}` | Generate license for specific product |
| POST | `/reset` | Reset configuration |
| GET | `/api/config` | Get current configuration (JSON) |

### Example Requests

```bash
# Get current configuration
curl -X GET http://localhost:8080/api/config

# Generate IDEA license
curl -X POST http://localhost:8080/generate/IDEA

# Generate default license
curl -X POST http://localhost:8080/generate
```

## ⚠️ Important Notes

### 🚨 Legal & Ethical Use
- **Educational Purpose Only** - This tool is strictly for learning and research
- **No Commercial Use** - Commercial usage is prohibited
- **User Responsibility** - Users are responsible for any consequences

### 🔧 Technical Requirements
- **Java 17+** - Ensure you have the correct Java version
- **File Permissions** - Certificate storage path needs read/write access
- **Network Access** - Some features may require internet connection
- **Security** - Use in secure environments only

### 💡 Best Practices
- **Backup Configuration** - Save your settings before making changes
- **Test Environment** - Try in a test environment first
- **Keep Updated** - Use the latest version for best experience

## 📄 License & Disclaimer

```
⚠️  EDUCATIONAL USE ONLY ⚠️

This project is provided for educational and learning purposes only.
Commercial use is strictly prohibited.

Users are solely responsible for any consequences arising from the use of this tool.
The authors and contributors assume no liability for any damages or legal issues.

By using this software, you acknowledge that you understand and agree to these terms.
```

## 🤝 Contributing

We welcome contributions to improve this project!

### How to Contribute
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Contribution Guidelines
- Follow existing code style
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass

## 📞 Contact & Support

<div align="center">

| 📋 Information | 📝 Details |
|----------------|------------|
| 👨‍💻 **Author** | CactusLi |
| 🏷️ **Version** | v2.0.0 |
| 📅 **Last Updated** | 2025-01-04 |
| 🎨 **UI Framework** | Tailwind CSS |
| ⚡ **Backend** | Spring Boot 3.2.1 |

</div>

---

<div align="center">

**⚠️ IMPORTANT REMINDER ⚠️**

**This tool is for educational use only!**

**本工具仅供学习交流使用！**

</div>

---

# 🇨🇳 中文文档

<div align="center">

**简体中文文档 | Simplified Chinese Documentation**

*现代化的 JetBrains 许可证生成器，基于 Spring Boot 3.x 开发*

</div>

<div align="right">

**[🔝 返回顶部](#-jetbrains-license-generator-v200)** | **[🇺🇸 English Documentation](#-quick-start)**

</div>

## 📑 文档目录

- [🚀 快速开始](#-快速开始)
- [📋 项目简介](#-项目简介)
- [🎯 支持的产品](#-支持的产品)
- [🚀 快速开始指南](#-快速开始-1)
- [🎮 使用方法](#-使用方法)
- [🛠️ VM选项配置详解](#️-vm选项配置详解)
- [⚙️ 配置说明](#️-配置说明)
- [🔧 激活方法](#-激活方法)
- [📁 项目结构](#-项目结构)
- [🌟 新版本特性](#-新版本特性)
- [🛠️ 技术栈](#️-技术栈)
- [🔍 API 接口](#-api-接口)
- [⚠️ 注意事项](#️-注意事项)

## 🚀 快速开始

### ⚡ 一分钟快速部署

```bash
# 1. 克隆并构建项目
git clone https://github.com/your-repo/jetbrains-license.git
cd jetbrains-license
mvn clean package -DskipTests

# 2. 启动应用程序
java -jar target/jetbrains-license-1.0.1.jar

# 3. 打开浏览器访问
# 地址: http://localhost:8080
```

### 📋 详细步骤指南

| 步骤 | 操作 | 说明 |
|------|------|------|
| 1️⃣ | **克隆并构建** | `mvn clean package -DskipTests` |
| 2️⃣ | **启动应用** | `java -jar target/jetbrains-license-1.0.1.jar` |
| 3️⃣ | **打开Web界面** | 访问 `http://localhost:8080` |
| 4️⃣ | **配置参数** | 进入 `/config` 页面设置 |
| 5️⃣ | **生成许可证** | 在首页点击"生成许可证" |
| 6️⃣ | **配置VM选项** | 访问 `/vmoptions` 自动配置 |
| 7️⃣ | **激活JetBrains** | 在IDE中使用生成的许可证 |

## 📋 项目简介

**JetBrains License Generator** 是一个基于 Spring Boot 3.x 开发的现代化许可证生成工具，提供直观的 Web 界面用于生成和管理 JetBrains 产品许可证，并具备自动化 VM 配置功能。

### 🎯 项目功能

本应用程序简化了以下流程：
- **生成许可证** - 为所有 JetBrains IDE（IDEA、WebStorm、PyCharm 等）生成许可证
- **自动配置VM选项** - 一键配置 JetBrains 产品的 VM 选项
- **证书管理** - 通过 Web 界面管理证书和许可证参数
- **实时反馈** - 在许可证生成过程中提供实时反馈

### ✨ 主要特性

- 🌐 **现代化 Web 界面** - 基于 Tailwind CSS 的精美响应式设计
- 🛠️ **自动化VM配置** - 一键配置所有 JetBrains IDE
- ⚙️ **动态配置管理** - 通过 Web 界面实时调整参数
- 🎯 **全产品支持** - 支持所有 JetBrains 产品（IDEA、WebStorm、PyCharm、GoLand 等）
- 🔧 **Spring Boot 3.x** - 基于最新的企业级框架构建
- 📱 **移动端响应式** - 在桌面、平板和手机上都有完美体验
- 🔒 **输入验证** - 全面的验证和错误处理机制
- 📊 **实时反馈** - Ajax 驱动的即时结果显示
- 🚀 **高性能** - 针对速度和可靠性进行优化

### 🎯 支持的产品

<table>
<tr>
<th>产品</th>
<th>代码</th>
<th>说明</th>
<th>产品</th>
<th>代码</th>
<th>说明</th>
</tr>
<tr>
<td><b>IntelliJ IDEA</b></td>
<td><code>II, PSI, PCWMP</code></td>
<td>Java 开发 IDE</td>
<td><b>WebStorm</b></td>
<td><code>WS, PSI, PCWMP</code></td>
<td>Web 开发 IDE</td>
</tr>
<tr>
<td><b>PyCharm</b></td>
<td><code>PC, PSI, PCWMP</code></td>
<td>Python 开发 IDE</td>
<td><b>GoLand</b></td>
<td><code>GO, PSI, PCWMP</code></td>
<td>Go 开发 IDE</td>
</tr>
<tr>
<td><b>CLion</b></td>
<td><code>CL, PSI, PCWMP</code></td>
<td>C/C++ 开发 IDE</td>
<td><b>PhpStorm</b></td>
<td><code>PS, PSI, PCWMP</code></td>
<td>PHP 开发 IDE</td>
</tr>
<tr>
<td><b>Rider</b></td>
<td><code>RD, PSI, PCWMP</code></td>
<td>.NET 开发 IDE</td>
<td><b>DataGrip</b></td>
<td><code>DG, PSI, PCWMP</code></td>
<td>数据库工具</td>
</tr>
<tr>
<td colspan="3"><b>RubyMine</b> - <code>RM, PSI, PCWMP</code> - Ruby 开发 IDE</td>
<td colspan="3"><b>更多产品...</b> - 支持所有 JetBrains 产品</td>
</tr>
</table>

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
打开浏览器访问：http://localhost:8080
```

## 🎮 使用方法

### Web 界面方式（推荐）

1. **启动应用**
   ```bash
   java -jar target/jetbrains-license-1.0.1.jar --server.port=8081
   ```

2. **配置参数**
   - 访问 http://localhost:8080/config
   - 设置证书持有者名称、有效期等参数
   - 选择目标产品类型

3. **生成许可证**
   - 返回首页 http://localhost:8080
   - 点击"生成许可证"按钮
   - 复制生成的许可证代码

4. **配置VM选项** ⭐ **重要步骤**
   - 访问 http://localhost:8080/vmoptions
   - 确保 `doc/jetbra/ja-netfilter.jar` 文件存在
   - 点击"开始配置"按钮，自动配置所有JetBrains产品
   - 等待配置完成

5. **激活JetBrains产品**
   - 重启对应的JetBrains IDE
   - 在激活界面选择"许可证服务器"或"激活码"
   - 输入生成的许可证代码
   - 完成激活

### 命令行方式（兼容旧版本）

```bash
# 编译项目
mvn clean package -DskipTests

# 运行传统方式
java -cp target/jetbrains-license-1.0.1.jar com.cactusli.license.JetbrainsLicense
```

## 🛠️ VM选项配置详解

### 🎯 功能概述

VM选项配置是JetBrains License Generator的核心功能，用于自动配置JetBrains产品的VM选项，添加ja-netfilter.jar代理，这是激活JetBrains产品的**关键步骤**。

### ✅ 支持的产品

| 产品 | 说明 | 产品 | 说明 |
|------|------|------|------|
| **IntelliJ IDEA** | Java开发IDE | **WebStorm** | JavaScript开发IDE |
| **PyCharm** | Python开发IDE | **GoLand** | Go开发IDE |
| **CLion** | C/C++开发IDE | **PhpStorm** | PHP开发IDE |
| **Rider** | .NET开发IDE | **DataGrip** | 数据库工具 |
| **RubyMine** | Ruby开发IDE | **AppCode** | iOS开发IDE |
| **DataSpell** | 数据科学IDE | **Gateway** | 远程开发工具 |
| **JetBrains Client** | 客户端工具 | **Android Studio** | Android开发IDE |
| **DevEco Studio** | 华为开发IDE | | |

### 🚀 核心功能

1. **🔍 自动检测** - 检测ja-netfilter.jar文件是否存在
2. **⚡ 灵活配置** - 支持配置所有产品或选择特定产品
3. **📁 路径自定义** - 支持自定义jar路径和vmoptions文件路径
4. **🔄 智能处理** - 自动移除旧配置，添加新配置
5. **📊 状态显示** - 实时显示配置结果和产品状态
6. **🛡️ 错误处理** - 详细的错误信息和处理建议

### 📋 详细使用步骤

#### 1. 准备工作
- 确保 `doc/jetbra/ja-netfilter.jar` 文件存在于项目目录中
- 启动应用：`java -jar target/jetbrains-license-1.0.1.jar --server.port=8081`

#### 2. 访问配置页面
```
http://localhost:8080/vmoptions
```

#### 3. 配置选项

**🔧 基础配置**
- **配置所有产品**: 点击"配置所有产品"按钮，一键配置所有支持的JetBrains产品
- **选择性配置**: 点击产品卡片选择需要配置的产品，然后点击"配置选定产品"

**📁 高级配置**
- **自定义jar路径**: 勾选"使用自定义jar路径"，点击"浏览"选择ja-netfilter.jar文件
- **自定义vmoptions路径**: 在产品卡片中勾选"自定义路径"，选择对应的vmoptions文件

#### 4. 执行配置
1. 根据需要选择配置方式
2. 点击对应的配置按钮
3. 等待配置完成，查看结果

#### 5. 完成激活
1. **重启IDE**: 配置完成后重启对应的JetBrains IDE
2. **使用许可证**: 在IDE中使用生成的许可证进行激活

### 🔧 技术原理

#### 配置过程
1. **文件检测**: 检查 `doc/jetbra/ja-netfilter.jar` 是否存在
2. **vmoptions定位**: 找到各产品的vmoptions文件
3. **内容处理**:
   - 读取现有vmoptions内容
   - 移除旧的javaagent配置（避免重复）
   - 添加新的javaagent配置
4. **文件写入**: 将更新后的内容写入vmoptions文件

#### 添加的配置
```
-javaagent:D:\path\to\doc\jetbra\ja-netfilter.jar=jetbrains
```

### 🌐 API接口

| 接口 | 方法 | 说明 |
|------|------|------|
| `/api/vmoptions/status` | GET | 获取状态信息 |
| `/api/vmoptions/products` | GET | 获取产品列表 |
| `/api/vmoptions/configure` | POST | 统一配置接口 |
| `/api/vmoptions/configure-all` | POST | 配置所有产品（兼容） |

### ⚠️ 注意事项

#### 重要提醒
1. **文件权限**: 确保应用有读写vmoptions文件的权限
2. **IDE重启**: 配置完成后必须重启对应的IDE
3. **路径正确**: ja-netfilter.jar必须位于正确的路径
4. **备份建议**: 建议在配置前备份原始vmoptions文件

#### 故障排除
1. **文件不存在**: 检查ja-netfilter.jar路径是否正确
2. **权限不足**: 以管理员身份运行应用
3. **配置失败**: 检查vmoptions文件是否存在且可写
4. **IDE无法启动**: 检查vmoptions文件语法是否正确

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
│   │   ├── config.html                         # 配置页
│   │   ├── vmoptions-advanced.html             # VM选项配置页
│   │   └── layout.html                         # 布局模板
│   ├── application.yml                         # 应用配置
│   └── cert/                                   # 证书存放目录
├── doc/                                        # 文档和工具
└── pom.xml                                     # Maven 配置
```

## 🌟 新版本特性

### v2.0.0 更新内容

- ✅ **升级到 Spring Boot 3.x** - 使用最新的 Spring Boot 框架
- ✅ **全面采用 Tailwind CSS** - 替换 Bootstrap，使用现代化的 Tailwind CSS 框架
- ✅ **现代化 Web 界面** - 全新的响应式设计，玻璃态效果，渐变背景
- ✅ **动态配置管理** - 支持运行时修改配置参数
- ✅ **多产品快速切换** - 一键切换不同 JetBrains 产品
- ✅ **参数验证** - 完整的输入验证和错误提示
- ✅ **实时生成** - Ajax 异步生成，无需刷新页面
- ✅ **移动端支持** - 响应式设计，完美支持手机和平板访问
- ✅ **向后兼容** - 保持对旧版本命令行方式的支持
- ✅ **交互动画** - 添加平滑过渡动画和悬停效果
- ✅ **现代化提示** - 美观的提示消息和反馈系统
- ✅ **优化的VM配置** - 简化vmoptions文件路径输入，移除冗余功能

## 🛠️ 技术栈

### 后端技术
- **Spring Boot 3.2.1** - 现代化的Java应用框架
- **Spring Web MVC** - RESTful API 和 Web 控制器
- **Thymeleaf** - 服务端模板引擎
- **Maven** - 项目构建和依赖管理
- **Java 17+** - 最新的Java长期支持版本

### 前端技术
- **Tailwind CSS 3.0+** - 现代化的CSS框架
- **JavaScript ES6+** - 现代JavaScript特性
- **Font Awesome 6.4** - 图标库
- **jQuery 3.6** - JavaScript库（用于Ajax）
- **响应式设计** - 移动端优先的设计理念

### 设计特色
- **🎨 现代化UI设计** - 使用Tailwind CSS打造的现代化界面
- **🌈 渐变色彩** - 美观的渐变背景和按钮效果
- **💫 动画效果** - 平滑的过渡动画和交互反馈
- **📱 移动端优化** - 完美适配各种设备尺寸
- **🔍 玻璃态效果** - 现代化的毛玻璃背景效果
- **⚡ 快速响应** - 优化的加载速度和交互体验

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

---

<div align="center">
<div align="center">

| 📋 项目信息 | 📝 详细内容 |
|-------------|-------------|
| 👨‍💻 **开发者** | CactusLi |
| 🏷️ **当前版本** | v2.0.0 |
| 📅 **最后更新** | 2025-01-04 |
| 🎨 **前端框架** | Tailwind CSS 3.0+ |
| ⚡ **后端框架** | Spring Boot 3.2.1 |
| 🔗 **项目地址** | [GitHub Repository](#) |

</div>

---

## ⚠️ 重要声明

<div align="center">

**🚨 EDUCATIONAL USE ONLY 🚨**

**本工具仅供学习交流使用，请勿用于商业用途！**

**This tool is for educational purposes only!**

---

### 🔗 快速导航 | Quick Navigation

| 🇺🇸 English | 🇨🇳 中文 | 🔗 链接 |
|-------------|---------|-------|
| [📖 English Docs](#-quick-start) | [📖 中文文档](#-快速开始) | [🌐 Web Interface](http://localhost:8080) |
| [🚀 Quick Start](#-quick-start) | [🚀 快速开始](#-快速开始) | [⚙️ Configuration](http://localhost:8080/config) |
| [🛠️ Tech Stack](#️-tech-stack) | [🛠️ 技术栈](#️-技术栈) | [🔧 VM Options](http://localhost:8080/vmoptions) |

---

<sub>Made with ❤️ by CactusLi | Powered by Spring Boot 3.x & Tailwind CSS</sub>

</div>
