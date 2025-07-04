package com.cactusli.license.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Pattern;

/**
 * VM选项配置服务
 * 用于配置JetBrains产品的vmoptions文件
 */
@Slf4j
@Service
public class VmOptionsService {
    
    private static final String[] JETBRAINS_PRODUCTS = {
        "idea", "clion", "phpstorm", "goland", "pycharm", "webstorm", 
        "webide", "rider", "datagrip", "rubymine", "appcode", "dataspell", 
        "gateway", "jetbrains_client", "jetbrainsclient", "studio", "devecostudio"
    };
    
    private static final Pattern JAVAAGENT_PATTERN = Pattern.compile(
        "^-javaagent:.*[/\\\\]ja-netfilter\\.jar.*", 
        Pattern.CASE_INSENSITIVE
    );
    
    /**
     * 配置所有JetBrains产品的vmoptions
     */
    public Map<String, Object> configureAllProducts() {
        Map<String, Object> result = new HashMap<>();
        List<String> successProducts = new ArrayList<>();
        List<String> failedProducts = new ArrayList<>();
        
        try {
            // 获取ja-netfilter.jar的路径
            Path jarPath = getJaNetfilterJarPath();
            if (!Files.exists(jarPath)) {
                result.put("success", false);
                result.put("message", "ja-netfilter.jar 文件不存在: " + jarPath);
                return result;
            }
            
            // 为每个产品配置vmoptions
            for (String product : JETBRAINS_PRODUCTS) {
                try {
                    if (configureProduct(product, jarPath)) {
                        successProducts.add(product);
                        log.info("成功配置产品: {}", product);
                    } else {
                        failedProducts.add(product);
                        log.warn("配置产品失败: {}", product);
                    }
                } catch (Exception e) {
                    failedProducts.add(product);
                    log.error("配置产品异常: {}", product, e);
                }
            }
            
            result.put("success", true);
            result.put("message", String.format("配置完成！成功: %d, 失败: %d", 
                successProducts.size(), failedProducts.size()));
            result.put("successProducts", successProducts);
            result.put("failedProducts", failedProducts);
            result.put("jarPath", jarPath.toString());
            
        } catch (Exception e) {
            log.error("配置vmoptions失败", e);
            result.put("success", false);
            result.put("message", "配置失败: " + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 配置单个产品的vmoptions
     */
    private boolean configureProduct(String product, Path jarPath) throws IOException {
        Path vmOptionsFile = getVmOptionsPath(product);
        
        if (!Files.exists(vmOptionsFile)) {
            log.warn("vmoptions文件不存在: {}", vmOptionsFile);
            return false;
        }
        
        // 读取现有内容
        List<String> lines = Files.readAllLines(vmOptionsFile);
        List<String> newLines = new ArrayList<>();
        
        // 移除已存在的javaagent配置
        for (String line : lines) {
            if (!JAVAAGENT_PATTERN.matcher(line.trim()).matches()) {
                newLines.add(line);
            }
        }
        
        // 添加新的javaagent配置
        String javaagentLine = "-javaagent:" + jarPath.toString() + "=jetbrains";
        newLines.add(javaagentLine);
        
        // 写入文件
        Files.write(vmOptionsFile, newLines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        
        return true;
    }
    
    /**
     * 获取ja-netfilter.jar的路径
     */
    private Path getJaNetfilterJarPath() {
        // 从项目根目录开始查找
        Path projectRoot = Paths.get("").toAbsolutePath();
        Path jarPath = projectRoot.resolve("doc/jetbra/ja-netfilter.jar");
        
        if (Files.exists(jarPath)) {
            return jarPath;
        }
        
        // 如果在项目根目录找不到，尝试在当前目录查找
        jarPath = Paths.get("doc/jetbra/ja-netfilter.jar");
        if (Files.exists(jarPath)) {
            return jarPath.toAbsolutePath();
        }
        
        // 最后尝试相对路径
        return Paths.get("doc/jetbra/ja-netfilter.jar").toAbsolutePath();
    }
    
    /**
     * 获取vmoptions文件路径
     */
    private Path getVmOptionsPath(String product) {
        Path projectRoot = Paths.get("").toAbsolutePath();
        return projectRoot.resolve("doc/jetbra/vmoptions/" + product + ".vmoptions");
    }
    
    /**
     * 获取支持的产品列表
     */
    public List<Map<String, String>> getSupportedProducts() {
        List<Map<String, String>> products = new ArrayList<>();
        
        Map<String, String> productNames = new HashMap<>();
        productNames.put("idea", "IntelliJ IDEA");
        productNames.put("clion", "CLion");
        productNames.put("phpstorm", "PhpStorm");
        productNames.put("goland", "GoLand");
        productNames.put("pycharm", "PyCharm");
        productNames.put("webstorm", "WebStorm");
        productNames.put("webide", "WebIDE");
        productNames.put("rider", "Rider");
        productNames.put("datagrip", "DataGrip");
        productNames.put("rubymine", "RubyMine");
        productNames.put("appcode", "AppCode");
        productNames.put("dataspell", "DataSpell");
        productNames.put("gateway", "Gateway");
        productNames.put("jetbrains_client", "JetBrains Client");
        productNames.put("jetbrainsclient", "JetBrains Client");
        productNames.put("studio", "Android Studio");
        productNames.put("devecostudio", "DevEco Studio");
        
        for (String product : JETBRAINS_PRODUCTS) {
            Map<String, String> productInfo = new HashMap<>();
            productInfo.put("key", product);
            productInfo.put("name", productNames.getOrDefault(product, product.toUpperCase()));
            
            // 检查vmoptions文件是否存在
            Path vmOptionsFile = getVmOptionsPath(product);
            productInfo.put("available", Files.exists(vmOptionsFile) ? "true" : "false");
            
            products.add(productInfo);
        }
        
        return products;
    }
    
    /**
     * 检查ja-netfilter.jar是否存在
     */
    public boolean isJaNetfilterAvailable() {
        Path jarPath = getJaNetfilterJarPath();
        return Files.exists(jarPath);
    }
    
    /**
     * 获取ja-netfilter.jar的路径信息
     */
    public Map<String, Object> getJaNetfilterInfo() {
        Map<String, Object> info = new HashMap<>();
        Path jarPath = getJaNetfilterJarPath();
        
        info.put("path", jarPath.toString());
        info.put("exists", Files.exists(jarPath));
        
        if (Files.exists(jarPath)) {
            try {
                info.put("size", Files.size(jarPath));
                info.put("lastModified", Files.getLastModifiedTime(jarPath).toString());
            } catch (IOException e) {
                log.warn("获取文件信息失败", e);
            }
        }
        
        return info;
    }
}
