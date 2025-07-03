package com.cactusli.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * JetBrains License Generator Spring Boot Application
 * 
 * @author CactusLi
 * @version 2.0.0
 * @since 2024-12-02
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class JetbrainsLicenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetbrainsLicenseApplication.class, args);
    }
}
