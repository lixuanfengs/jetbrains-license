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
}
