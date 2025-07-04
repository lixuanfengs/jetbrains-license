# VM选项配置功能说明

## 🎯 功能概述

VM选项配置功能是JetBrains License Generator的核心功能之一，用于自动配置JetBrains产品的VM选项，添加ja-netfilter.jar代理，这是激活JetBrains产品的关键步骤。

## 🚀 主要特性

### ✅ 支持的产品
- **IntelliJ IDEA** - Java开发IDE
- **WebStorm** - JavaScript开发IDE  
- **PyCharm** - Python开发IDE
- **GoLand** - Go开发IDE
- **CLion** - C/C++开发IDE
- **PhpStorm** - PHP开发IDE
- **Rider** - .NET开发IDE
- **DataGrip** - 数据库工具
- **RubyMine** - Ruby开发IDE
- **AppCode** - iOS开发IDE
- **DataSpell** - 数据科学IDE
- **Gateway** - 远程开发工具
- **JetBrains Client** - 客户端工具
- **Android Studio** - Android开发IDE
- **DevEco Studio** - 华为开发IDE

### ✅ 核心功能
1. **自动检测** - 检测ja-netfilter.jar文件是否存在
2. **批量配置** - 一键配置所有支持的产品
3. **智能处理** - 自动移除旧配置，添加新配置
4. **状态显示** - 实时显示配置结果和产品状态
5. **错误处理** - 详细的错误信息和处理建议

## 📋 使用步骤

### 1. 确保文件存在
确保 `doc/jetbra/ja-netfilter.jar` 文件存在于项目目录中。

### 2. 启动应用
```bash
# Windows
start.bat

# Linux/macOS
./start.sh

# 或直接运行
java -jar target/jetbrains-license-1.0.1.jar --server.port=8081
```

### 3. 访问VM选项配置页面
```
http://localhost:8081/vmoptions
```

### 4. 执行配置
1. 检查ja-netfilter.jar状态（绿色表示文件存在）
2. 查看支持的产品列表
3. 点击"开始配置"按钮
4. 等待配置完成，查看结果

### 5. 重启IDE
配置完成后，重启对应的JetBrains IDE。

### 6. 使用许可证
在IDE中使用生成的许可证进行激活。

## 🔧 技术原理

### 配置过程
1. **文件检测**: 检查 `doc/jetbra/ja-netfilter.jar` 是否存在
2. **vmoptions定位**: 找到各产品的vmoptions文件
3. **内容处理**: 
   - 读取现有vmoptions内容
   - 移除旧的javaagent配置（避免重复）
   - 添加新的javaagent配置
4. **文件写入**: 将更新后的内容写入vmoptions文件

### 添加的配置
```
-javaagent:D:\path\to\doc\jetbra\ja-netfilter.jar=jetbrains
```

### 文件路径
- **vmoptions文件**: `doc/jetbra/vmoptions/{product}.vmoptions`
- **ja-netfilter.jar**: `doc/jetbra/ja-netfilter.jar`

## 🌐 API接口

### 获取状态
```http
GET /api/vmoptions/status
```

### 获取产品列表
```http
GET /api/vmoptions/products
```

### 配置所有产品
```http
POST /api/vmoptions/configure-all
```

## ⚠️ 注意事项

### 重要提醒
1. **文件权限**: 确保应用有读写vmoptions文件的权限
2. **IDE重启**: 配置完成后必须重启对应的IDE
3. **路径正确**: ja-netfilter.jar必须位于正确的路径
4. **备份建议**: 建议在配置前备份原始vmoptions文件

### 故障排除
1. **文件不存在**: 检查ja-netfilter.jar路径是否正确
2. **权限不足**: 以管理员身份运行应用
3. **配置失败**: 检查vmoptions文件是否存在且可写
4. **IDE无法启动**: 检查vmoptions文件语法是否正确

## 📱 界面功能

### 主要区域
1. **状态显示区**: 显示ja-netfilter.jar的状态信息
2. **配置操作区**: 一键配置按钮和说明
3. **产品列表区**: 显示所有支持的产品及其状态
4. **结果显示区**: 显示配置结果和详细信息
5. **使用说明区**: 详细的操作指南

### 状态指示
- 🟢 **绿色**: 文件存在，配置可用
- 🔴 **红色**: 文件不存在或配置不可用
- 🟡 **黄色**: 警告状态

## 🎉 使用效果

配置成功后，JetBrains产品将能够：
1. 加载ja-netfilter.jar代理
2. 绕过许可证验证
3. 接受生成的许可证
4. 正常激活和使用

---

**⚠️ 免责声明**: 此工具仅供学习交流使用，请勿用于商业用途。建议购买正版软件支持开发者。
