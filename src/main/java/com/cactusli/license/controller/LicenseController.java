package com.cactusli.license.controller;

import com.cactusli.license.config.LicenseConfig;
import com.cactusli.license.constant.Constant;
import com.cactusli.license.service.LicenseService;
import com.cactusli.license.service.VmOptionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 许可证Web控制器
 * 
 * @author CactusLi
 * @version 2.0.0
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class LicenseController {
    
    private final LicenseService licenseService;
    private final VmOptionsService vmOptionsService;
    
    /**
     * 首页
     */
    @GetMapping("/")
    public String index(Model model) {
        try {
            LicenseConfig config = licenseService.getCurrentConfig();
            model.addAttribute("config", config);
            model.addAttribute("productTypes", getProductTypes());
            return "index";
        } catch (Exception e) {
            log.error("首页加载失败", e);
            model.addAttribute("config", null);
            model.addAttribute("productTypes", getProductTypes());
            model.addAttribute("error", "配置加载失败: " + e.getMessage());
            return "index";
        }
    }
    
    /**
     * 配置页面
     */
    @GetMapping("/config")
    public String configPage(Model model) {
        model.addAttribute("config", licenseService.getCurrentConfig());
        model.addAttribute("productTypes", getProductTypes());
        return "config";
    }
    
    /**
     * 更新配置
     */
    @PostMapping("/config")
    public String updateConfig(@Valid @ModelAttribute("config") LicenseConfig config, 
                              BindingResult result, 
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productTypes", getProductTypes());
            return "config";
        }
        
        try {
            licenseService.updateConfig(config);
            redirectAttributes.addFlashAttribute("success", "配置更新成功！");
            return "redirect:/";
        } catch (Exception e) {
            log.error("更新配置失败", e);
            model.addAttribute("error", "更新配置失败: " + e.getMessage());
            model.addAttribute("productTypes", getProductTypes());
            return "config";
        }
    }
    
    /**
     * 生成许可证
     */
    @PostMapping("/generate")
    @ResponseBody
    public Map<String, Object> generateLicense() {
        Map<String, Object> result = new HashMap<>();
        try {
            String license = licenseService.generateLicense();
            result.put("success", true);
            result.put("license", license);
            result.put("message", "许可证生成成功！");
        } catch (Exception e) {
            log.error("生成许可证失败", e);
            result.put("success", false);
            result.put("message", "生成许可证失败: " + e.getMessage());
        }
        return result;
    }
    
    /**
     * 生成指定产品的许可证
     */
    @PostMapping("/generate/{productType}")
    @ResponseBody
    public Map<String, Object> generateLicenseForProduct(@PathVariable String productType) {
        Map<String, Object> result = new HashMap<>();
        try {
            String[] productCodes = getProductCodesByType(productType);
            String license = licenseService.generateLicense(productCodes);
            result.put("success", true);
            result.put("license", license);
            result.put("message", "许可证生成成功！");
            result.put("productType", productType);
        } catch (Exception e) {
            log.error("生成{}许可证失败", productType, e);
            result.put("success", false);
            result.put("message", "生成许可证失败: " + e.getMessage());
        }
        return result;
    }
    
    /**
     * 重置配置
     */
    @PostMapping("/reset")
    public String resetConfig(RedirectAttributes redirectAttributes) {
        try {
            licenseService.resetConfig();
            redirectAttributes.addFlashAttribute("success", "配置已重置为默认值！");
        } catch (Exception e) {
            log.error("重置配置失败", e);
            redirectAttributes.addFlashAttribute("error", "重置配置失败: " + e.getMessage());
        }
        return "redirect:/config";
    }
    
    /**
     * 获取当前配置信息
     */
    @GetMapping("/api/config")
    @ResponseBody
    public LicenseConfig getCurrentConfig() {
        return licenseService.getCurrentConfig();
    }
    
    /**
     * 获取产品类型映射
     */
    private Map<String, String> getProductTypes() {
        Map<String, String> productTypes = new HashMap<>();
        productTypes.put("IDEA", "IntelliJ IDEA");
        productTypes.put("WEBSTORM", "WebStorm");
        productTypes.put("PYCHARM", "PyCharm");
        productTypes.put("GOLAND", "GoLand");
        productTypes.put("CLION", "CLion");
        productTypes.put("PHPSTORM", "PhpStorm");
        productTypes.put("RIDER", "Rider");
        productTypes.put("DATAGRIP", "DataGrip");
        productTypes.put("RUBYMINE", "RubyMine");
        return productTypes;
    }
    
    /**
     * 根据产品类型获取产品代码
     */
    private String[] getProductCodesByType(String productType) {
        switch (productType.toUpperCase()) {
            case "IDEA":
                return Constant.IDEA_CODES;
            case "WEBSTORM":
                return Constant.WEBSTORM_CODES;
            case "PYCHARM":
                return Constant.PYCHARM_CODES;
            case "GOLAND":
                return Constant.GOLAND_CODES;
            case "CLION":
                return Constant.CLION_CODES;
            case "PHPSTORM":
                return Constant.PHPSTORM_CODES;
            case "RIDER":
                return Constant.RIDER_CODES;
            case "DATAGRIP":
                return Constant.DATAGRIP_CODES;
            case "RUBYMINE":
                return Constant.RUBYMINE_CODES;
            default:
                return Constant.DEFAULT_CODES;
        }
    }

    // ==================== VM选项配置相关端点 ====================

    /**
     * VM选项配置页面（统一页面）
     */
    @GetMapping("/vmoptions")
    public String vmOptionsPage(Model model) {
        model.addAttribute("supportedProducts", vmOptionsService.getSupportedProducts());
        model.addAttribute("jaNetfilterInfo", vmOptionsService.getJaNetfilterInfo());
        model.addAttribute("isJaNetfilterAvailable", vmOptionsService.isJaNetfilterAvailable());
        return "vmoptions-advanced";
    }

    /**
     * 统一的VM选项配置接口
     */
    @PostMapping("/api/vmoptions/configure")
    @ResponseBody
    public Map<String, Object> configureVmOptions(@RequestBody Map<String, Object> request) {
        try {
            @SuppressWarnings("unchecked")
            List<String> selectedProducts = (List<String>) request.get("selectedProducts");
            String customJarPath = (String) request.get("customJarPath");
            @SuppressWarnings("unchecked")
            Map<String, String> customVmOptionsMap = (Map<String, String>) request.get("customVmOptionsMap");

            if (selectedProducts == null || selectedProducts.isEmpty()) {
                log.info("开始配置所有产品的VM选项");
            } else {
                log.info("开始配置选定产品的VM选项: {}", selectedProducts);
            }

            return vmOptionsService.configureProducts(selectedProducts, customJarPath, customVmOptionsMap);

        } catch (Exception e) {
            log.error("配置VM选项失败", e);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "配置失败: " + e.getMessage());
            return result;
        }
    }

    /**
     * 配置所有产品的VM选项（向下兼容）
     */
    @PostMapping("/api/vmoptions/configure-all")
    @ResponseBody
    public Map<String, Object> configureAllVmOptions() {
        log.info("开始配置所有产品的VM选项");
        return vmOptionsService.configureAllProducts();
    }

    /**
     * 获取支持的产品列表
     */
    @GetMapping("/api/vmoptions/products")
    @ResponseBody
    public Map<String, Object> getSupportedProducts() {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("products", vmOptionsService.getSupportedProducts());
        result.put("jaNetfilterInfo", vmOptionsService.getJaNetfilterInfo());
        return result;
    }

    /**
     * 检查ja-netfilter.jar状态
     */
    @GetMapping("/api/vmoptions/status")
    @ResponseBody
    public Map<String, Object> getVmOptionsStatus() {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("jaNetfilterAvailable", vmOptionsService.isJaNetfilterAvailable());
        result.put("jaNetfilterInfo", vmOptionsService.getJaNetfilterInfo());
        result.put("supportedProductsCount", vmOptionsService.getSupportedProducts().size());
        return result;
    }

    /**
     * 根据文件名搜索真实的文件路径
     */
    @PostMapping("/api/vmoptions/resolve-path")
    @ResponseBody
    public Map<String, Object> resolveFilePath(@RequestBody Map<String, String> request) {
        try {
            String fileName = request.get("fileName");
            String fileType = request.get("fileType"); // "jar" 或 "vmoptions"
            String productKey = request.get("productKey"); // 仅对vmoptions文件需要

            log.info("解析文件路径: fileName={}, fileType={}, productKey={}", fileName, fileType, productKey);

            Map<String, Object> result = new HashMap<>();
            List<String> possiblePaths = new ArrayList<>();
            String foundPath = null;

            if ("jar".equals(fileType)) {
                possiblePaths = findJarFilePaths(fileName);
            } else if ("vmoptions".equals(fileType)) {
                possiblePaths = findVmOptionsFilePaths(fileName, productKey);
            }

            // 查找第一个存在的路径
            for (String path : possiblePaths) {
                if (Files.exists(Paths.get(path))) {
                    foundPath = path;
                    break;
                }
            }

            result.put("success", true);
            result.put("fileName", fileName);
            result.put("foundPath", foundPath);
            result.put("possiblePaths", possiblePaths);
            result.put("exists", foundPath != null);

            return result;

        } catch (Exception e) {
            log.error("解析文件路径失败", e);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "解析文件路径失败: " + e.getMessage());
            return result;
        }
    }

    /**
     * 查找jar文件的可能路径
     */
    private List<String> findJarFilePaths(String fileName) {
        List<String> paths = new ArrayList<>();
        String userHome = System.getProperty("user.home");
        String currentDir = System.getProperty("user.dir");

        // 项目目录
        paths.add(currentDir + "/doc/jetbra/" + fileName);
        paths.add(currentDir + "\\doc\\jetbra\\" + fileName);

        // 下载目录
        paths.add(userHome + "/Downloads/" + fileName);
        paths.add(userHome + "\\Downloads\\" + fileName);

        // 桌面
        paths.add(userHome + "/Desktop/" + fileName);
        paths.add(userHome + "\\Desktop\\" + fileName);

        // 常见工具目录
        paths.add("D:/tools/jetbrains/" + fileName);
        paths.add("C:/tools/jetbrains/" + fileName);
        paths.add("D:/jetbrains/" + fileName);
        paths.add("C:/jetbrains/" + fileName);

        return paths;
    }

    /**
     * 查找vmoptions文件的可能路径
     */
    private List<String> findVmOptionsFilePaths(String fileName, String productKey) {
        List<String> paths = new ArrayList<>();
        String userHome = System.getProperty("user.home");
        String productUpper = productKey != null ? productKey.toUpperCase() : "";

        // JetBrains配置目录 (Windows)
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            String appData = System.getenv("APPDATA");
            if (appData != null) {
                // 不同版本的配置目录
                String[] versions = {"2023.3", "2023.2", "2023.1", "2024.1", "2024.2"};
                for (String version : versions) {
                    paths.add(appData + "\\JetBrains\\" + productUpper + version + "\\" + fileName);
                }
            }

            // 程序安装目录
            String[] installDirs = {
                "C:\\Program Files\\JetBrains",
                "C:\\Program Files (x86)\\JetBrains",
                "D:\\Program Files\\JetBrains"
            };

            for (String installDir : installDirs) {
                paths.add(installDir + "\\" + productUpper + "\\bin\\" + productKey + "64.exe.vmoptions");
                paths.add(installDir + "\\" + productUpper + " 2023.3\\bin\\" + productKey + "64.exe.vmoptions");
            }
        }

        // Linux/Mac配置目录
        paths.add(userHome + "/.config/JetBrains/" + productUpper + "2023.3/" + fileName);
        paths.add(userHome + "/Library/Application Support/JetBrains/" + productUpper + "2023.3/" + fileName);

        // 当前目录
        paths.add(System.getProperty("user.dir") + "/" + fileName);
        paths.add(System.getProperty("user.dir") + "\\" + fileName);

        return paths;
    }
}
