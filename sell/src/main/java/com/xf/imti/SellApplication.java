package com.xf.imti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.xf.xf.entity.mapper")
public class SellApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}
