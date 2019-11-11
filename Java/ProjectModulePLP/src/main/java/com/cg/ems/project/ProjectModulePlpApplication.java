package com.cg.ems.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.cg.ems.project")
public class ProjectModulePlpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectModulePlpApplication.class, args);
	}

}
