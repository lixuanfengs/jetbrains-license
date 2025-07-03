package com.cactusli.license.service;

import com.cactusli.license.config.LicenseConfig;
import com.cactusli.license.generator.CertificateGenerator;
import com.cactusli.license.generator.LicenseGenerator;
import com.cactusli.license.generator.PowerConfRuleGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 许可证服务类
 * 
 * @author CactusLi
 * @version 2.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LicenseService {
    
    private final LicenseConfig licenseConfig;
    
    /**
     * 生成完整的许可证
     * 
     * @return 生成的许可证字符串
     */
    public String generateLicense() {
        try {
            log.info("开始生成许可证，配置信息: {}", licenseConfig.getSummary());
            
            // 应用配置到常量类
            licenseConfig.applyToConstants();
            
            // 1. 生成证书和私钥
            log.info("步骤1: 生成证书和私钥");
            CertificateGenerator.generate();
            
            // 2. 生成证书校验规则
            log.info("步骤2: 生成证书校验规则");
            PowerConfRuleGenerator.generate();
            
            // 3. 生成许可证
            log.info("步骤3: 生成许可证");
            String license = LicenseGenerator.generate(licenseConfig.getProductCodes());
            
            log.info("许可证生成成功");
            return license;
            
        } catch (Exception e) {
            log.error("生成许可证失败", e);
            throw new RuntimeException("生成许可证失败: " + e.getMessage(), e);
        }
    }
    
    /**
     * 生成指定产品的许可证
     * 
     * @param productCodes 产品代码数组
     * @return 生成的许可证字符串
     */
    public String generateLicense(String[] productCodes) {
        try {
            log.info("开始生成指定产品的许可证，产品代码: {}", String.join(",", productCodes));
            
            // 应用配置到常量类
            licenseConfig.applyToConstants();
            
            // 1. 生成证书和私钥
            CertificateGenerator.generate();
            
            // 2. 生成证书校验规则
            PowerConfRuleGenerator.generate();
            
            // 3. 生成许可证
            String license = LicenseGenerator.generate(productCodes);
            
            log.info("指定产品许可证生成成功");
            return license;
            
        } catch (Exception e) {
            log.error("生成指定产品许可证失败", e);
            throw new RuntimeException("生成许可证失败: " + e.getMessage(), e);
        }
    }
    
    /**
     * 更新配置
     * 
     * @param config 新的配置
     */
    public void updateConfig(LicenseConfig config) {
        if (config.isValid()) {
            this.licenseConfig.setCertPath(config.getCertPath());
            this.licenseConfig.setLicenseeName(config.getLicenseeName());
            this.licenseConfig.setLicenseYears(config.getLicenseYears());
            this.licenseConfig.setIssuerName(config.getIssuerName());
            this.licenseConfig.setSubjectName(config.getSubjectName());
            this.licenseConfig.setProductType(config.getProductType());
            this.licenseConfig.setProductCodes(config.getProductCodes());
            
            log.info("配置已更新: {}", this.licenseConfig.getSummary());
        } else {
            throw new IllegalArgumentException("配置验证失败");
        }
    }
    
    /**
     * 获取当前配置
     * 
     * @return 当前配置
     */
    public LicenseConfig getCurrentConfig() {
        return licenseConfig;
    }
    
    /**
     * 重置配置为默认值
     */
    public void resetConfig() {
        licenseConfig.resetToDefaults();
        log.info("配置已重置为默认值: {}", licenseConfig.getSummary());
    }
    
    /**
     * 验证配置
     * 
     * @return 配置是否有效
     */
    public boolean validateConfig() {
        return licenseConfig.isValid();
    }
}
