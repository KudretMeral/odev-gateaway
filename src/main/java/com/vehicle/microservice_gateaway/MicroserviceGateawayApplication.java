package com.vehicle.microservice_gateaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="customAuditorAware")
@SpringBootApplication
public class MicroserviceGateawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGateawayApplication.class, args);
	}

}
