package com.cactusli.license;

import com.cactusli.license.generator.CertificateGenerator;
import com.cactusli.license.generator.LicenseGenerator;
import com.cactusli.license.generator.PowerConfRuleGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 * 传统命令行方式生成许可证
 * 保持向后兼容性
 *
 * @author CactusLi
 * @version 2.0.0
 * @deprecated 推荐使用Spring Boot Web应用方式
 */
@Slf4j
@Deprecated
public class JetbrainsLicense {
    public static void main(String[] args) throws Exception {
        log.info("使用传统命令行方式生成许可证");
        log.info("推荐使用Spring Boot Web应用方式: java -jar jetbrains-license-1.0.1.jar");

        // 1. 生成证书和私钥
        log.info("步骤1: 生成证书和私钥");
        CertificateGenerator.generate();

        // 2. 生成证书校验规则
        log.info("步骤2: 生成证书校验规则");
        PowerConfRuleGenerator.generate();

        // 3. 生成许可证
        log.info("步骤3: 生成许可证");
        String license = LicenseGenerator.generate();

        log.info("许可证生成完成！");
        log.info("Web应用地址: http://localhost:8080");
    }
}
