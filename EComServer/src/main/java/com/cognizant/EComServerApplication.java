package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EComServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComServerApplication.class, args);
	}

}
