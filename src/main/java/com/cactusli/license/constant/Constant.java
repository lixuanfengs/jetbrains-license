package com.cactusli.license.constant;

import java.io.File;

/**
 * 常量类 - 支持动态配置
 *
 * @author CactusLi
 * @version 2.0.0
 */
public class Constant {

    // ==================== 默认配置常量 ====================

    /**
     * 默认证书存放路径
     */
    public static final String DEFAULT_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "cert";

    /**
     * 默认证书持有者
     */
    public static final String DEFAULT_LICENSEE_NAME = "CactusLi";

    /**
     * 默认许可证有效期（年）
     */
    public static final int DEFAULT_LICENSE_YEARS = 10;

    /**
     * 默认证书颁发者
     */
    public static final String DEFAULT_ISSUER_NAME = "JetProfile CA";

    /**
     * 默认证书主题
     */
    public static final String DEFAULT_SUBJECT_NAME = "Novice-from-2024-01-19";

    // ==================== 产品代码常量 ====================

    /**
     * 默认产品代码 - IDEA
     */
    public static final String[] DEFAULT_CODES = {"II", "PSI", "PCWMP"};

    /**
     * IDEA 产品代码
     */
    public static final String[] IDEA_CODES = {"II", "PSI", "PCWMP"};

    /**
     * WebStorm 产品代码
     */
    public static final String[] WEBSTORM_CODES = {"WS", "PSI", "PCWMP"};

    /**
     * PyCharm 产品代码
     */
    public static final String[] PYCHARM_CODES = {"PC", "PSI", "PCWMP"};

    /**
     * GoLand 产品代码
     */
    public static final String[] GOLAND_CODES = {"GO", "PSI", "PCWMP"};

    /**
     * CLion 产品代码
     */
    public static final String[] CLION_CODES = {"CL", "PSI", "PCWMP"};

    /**
     * PhpStorm 产品代码
     */
    public static final String[] PHPSTORM_CODES = {"PS", "PSI", "PCWMP"};

    /**
     * Rider 产品代码
     */
    public static final String[] RIDER_CODES = {"RD", "PSI", "PCWMP"};

    /**
     * DataGrip 产品代码
     */
    public static final String[] DATAGRIP_CODES = {"DG", "PSI", "PCWMP"};

    /**
     * RubyMine 产品代码
     */
    public static final String[] RUBYMINE_CODES = {"RM", "PSI", "PCWMP"};

    // ==================== 动态配置变量 ====================

    /**
     * 当前证书存放路径
     */
    public static String PATH = DEFAULT_PATH;

    /**
     * 当前证书持有者
     */
    public static String LICENSEE_NAME = DEFAULT_LICENSEE_NAME;

    /**
     * 当前许可证有效期（年）
     */
    public static int LICENSE_YEARS = DEFAULT_LICENSE_YEARS;

    /**
     * 当前证书颁发者
     */
    public static String ISSUER_NAME = DEFAULT_ISSUER_NAME;

    /**
     * 当前证书主题
     */
    public static String SUBJECT_NAME = DEFAULT_SUBJECT_NAME;

    // ==================== 配置更新方法 ====================

    /**
     * 更新配置
     */
    public static void updateConfig(String certPath, String licenseeName, int licenseYears,
                                   String issuerName, String subjectName) {
        if (certPath != null && !certPath.trim().isEmpty()) {
            PATH = certPath;
        }
        if (licenseeName != null && !licenseeName.trim().isEmpty()) {
            LICENSEE_NAME = licenseeName;
        }
        if (licenseYears > 0) {
            LICENSE_YEARS = licenseYears;
        }
        if (issuerName != null && !issuerName.trim().isEmpty()) {
            ISSUER_NAME = issuerName;
        }
        if (subjectName != null && !subjectName.trim().isEmpty()) {
            SUBJECT_NAME = subjectName;
        }
    }

    /**
     * 重置为默认配置
     */
    public static void resetToDefaults() {
        PATH = DEFAULT_PATH;
        LICENSEE_NAME = DEFAULT_LICENSEE_NAME;
        LICENSE_YEARS = DEFAULT_LICENSE_YEARS;
        ISSUER_NAME = DEFAULT_ISSUER_NAME;
        SUBJECT_NAME = DEFAULT_SUBJECT_NAME;
    }

    /**
     * 获取当前配置摘要
     */
    public static String getConfigSummary() {
        return String.format("路径: %s, 持有者: %s, 有效期: %d年, 颁发者: %s, 主题: %s",
                           PATH, LICENSEE_NAME, LICENSE_YEARS, ISSUER_NAME, SUBJECT_NAME);
    }
}
