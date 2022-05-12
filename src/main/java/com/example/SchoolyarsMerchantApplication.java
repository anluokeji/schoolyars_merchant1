package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.schoolyars_merchant.dao")
@MapperScan(value = "com.example.receiving_address.dao")
public class SchoolyarsMerchantApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchoolyarsMerchantApplication.class, args);
         System.out.println("*********************启动成功********************");
    }

}
