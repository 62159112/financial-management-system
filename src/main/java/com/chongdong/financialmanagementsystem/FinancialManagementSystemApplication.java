package com.chongdong.financialmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chongdong.financialmanagementsystem.mapper")
public class FinancialManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialManagementSystemApplication.class, args);
    }

}
