package com.chenshinan.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chenshinan.framework.infra.mapper")
public class CsnFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsnFrameworkApplication.class, args);
    }
}
