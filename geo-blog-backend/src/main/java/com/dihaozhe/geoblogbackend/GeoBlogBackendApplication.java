package com.dihaozhe.geoblogbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dihaozhe.geoblogbackend.mapper")
public class GeoBlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoBlogBackendApplication.class, args);
        System.out.println(" knife4j 接口文档访问 http://localhost:8090/doc.html");
    }

}
