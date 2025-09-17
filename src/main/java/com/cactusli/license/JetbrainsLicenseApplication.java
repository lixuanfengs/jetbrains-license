package com.cactusli.license;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;

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

    @Value("${server.port:8080}")
    private int port;

    @Value("${server.servlet.context-path:/}")
    private String contextPath;

    public static void main(String[] args) {
        SpringApplication.run(JetbrainsLicenseApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            try {
                String hostAddress = InetAddress.getLocalHost().getHostAddress();
                String accessPath = contextPath.equals("/") ? "" : contextPath;

                System.out.println();
                System.out.println("==========================================");
                System.out.println("  JetBrains License Generator Started!");
                System.out.println("==========================================");
                System.out.println("  Local Access:    http://localhost:" + port + accessPath);
                System.out.println("  Network Access:  http://" + hostAddress + ":" + port + accessPath);
                System.out.println("==========================================");
                System.out.println();
            } catch (Exception e) {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("  JetBrains License Generator Started!");
                System.out.println("==========================================");
                System.out.println("  Local Access:    http://localhost:" + port + contextPath);
                System.out.println("==========================================");
                System.out.println();
            }
        };
    }
}
