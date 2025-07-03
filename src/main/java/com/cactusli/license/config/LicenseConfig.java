package com.cactusli.license.config;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.cactusli.license.constant.Constant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 许可证配置类
 * 用于管理动态配置参数
 * 
 * @author CactusLi
 * @version 2.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "jetbrains.license")
public class LicenseConfig {
    
    /**
     * 证书存放路径
     */
    @NotBlank(message = "证书路径不能为空")
    private String certPath = Constant.DEFAULT_PATH;
    
    /**
     * 证书持有者名称
     */
    @NotBlank(message = "证书持有者名称不能为空")
    private String licenseeName = Constant.DEFAULT_LICENSEE_NAME;
    
    /**
     * 许可证有效期（年）
     */
    @Min(value = 1, message = "许可证有效期必须大于0年")
    private int licenseYears = Constant.DEFAULT_LICENSE_YEARS;
    
    /**
     * 证书颁发者
     */
    @NotBlank(message = "证书颁发者不能为空")
    private String issuerName = Constant.DEFAULT_ISSUER_NAME;
    
    /**
     * 证书主题
     */
    @NotBlank(message = "证书主题不能为空")
    private String subjectName = Constant.DEFAULT_SUBJECT_NAME;
    
    /**
     * 产品代码
     */
    @NotNull(message = "产品代码不能为空")
    private String[] productCodes = Constant.DEFAULT_CODES;
    
    /**
     * 预设产品类型
     */
    @NotBlank(message = "产品类型不能为空")
    private String productType = "IDEA";
    
    /**
     * 构造函数
     */
    public LicenseConfig() {
    }
    
    /**
     * 带参数的构造函数
     */
    public LicenseConfig(String certPath, String licenseeName, int licenseYears, 
                        String issuerName, String subjectName, String[] productCodes) {
        this.certPath = StrUtil.isNotBlank(certPath) ? certPath : Constant.DEFAULT_PATH;
        this.licenseeName = StrUtil.isNotBlank(licenseeName) ? licenseeName : Constant.DEFAULT_LICENSEE_NAME;
        this.licenseYears = licenseYears > 0 ? licenseYears : Constant.DEFAULT_LICENSE_YEARS;
        this.issuerName = StrUtil.isNotBlank(issuerName) ? issuerName : Constant.DEFAULT_ISSUER_NAME;
        this.subjectName = StrUtil.isNotBlank(subjectName) ? subjectName : Constant.DEFAULT_SUBJECT_NAME;
        this.productCodes = ArrayUtil.isNotEmpty(productCodes) ? productCodes : Constant.DEFAULT_CODES;
    }
    
    /**
     * 根据产品类型设置产品代码
     */
    public void setProductType(String productType) {
        this.productType = productType;
        switch (productType.toUpperCase()) {
            case "IDEA":
                this.productCodes = Constant.IDEA_CODES;
                break;
            case "WEBSTORM":
                this.productCodes = Constant.WEBSTORM_CODES;
                break;
            case "PYCHARM":
                this.productCodes = Constant.PYCHARM_CODES;
                break;
            case "GOLAND":
                this.productCodes = Constant.GOLAND_CODES;
                break;
            case "CLION":
                this.productCodes = Constant.CLION_CODES;
                break;
            case "PHPSTORM":
                this.productCodes = Constant.PHPSTORM_CODES;
                break;
            case "RIDER":
                this.productCodes = Constant.RIDER_CODES;
                break;
            case "DATAGRIP":
                this.productCodes = Constant.DATAGRIP_CODES;
                break;
            case "RUBYMINE":
                this.productCodes = Constant.RUBYMINE_CODES;
                break;
            default:
                this.productCodes = Constant.DEFAULT_CODES;
                break;
        }
    }
    
    /**
     * 应用配置到常量类
     */
    public void applyToConstants() {
        Constant.updateConfig(this.certPath, this.licenseeName, this.licenseYears, 
                             this.issuerName, this.subjectName);
    }
    
    /**
     * 验证配置
     */
    public boolean isValid() {
        return StrUtil.isNotBlank(certPath) && 
               StrUtil.isNotBlank(licenseeName) && 
               licenseYears > 0 && 
               StrUtil.isNotBlank(issuerName) && 
               StrUtil.isNotBlank(subjectName) && 
               ArrayUtil.isNotEmpty(productCodes);
    }
    
    /**
     * 获取配置摘要
     */
    public String getSummary() {
        return String.format("证书路径: %s, 持有者: %s, 有效期: %d年, 产品类型: %s, 产品代码: %s", 
                           certPath, licenseeName, licenseYears, productType, 
                           ArrayUtil.join(productCodes, ","));
    }
    
    /**
     * 重置为默认配置
     */
    public void resetToDefaults() {
        this.certPath = Constant.DEFAULT_PATH;
        this.licenseeName = Constant.DEFAULT_LICENSEE_NAME;
        this.licenseYears = Constant.DEFAULT_LICENSE_YEARS;
        this.issuerName = Constant.DEFAULT_ISSUER_NAME;
        this.subjectName = Constant.DEFAULT_SUBJECT_NAME;
        this.productCodes = Constant.DEFAULT_CODES;
        this.productType = "IDEA";
    }
}
