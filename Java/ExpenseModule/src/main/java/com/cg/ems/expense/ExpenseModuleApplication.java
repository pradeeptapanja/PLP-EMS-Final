package com.cg.ems.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.cg.ems.expense")
public class ExpenseModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseModuleApplication.class, args);
	}

}
