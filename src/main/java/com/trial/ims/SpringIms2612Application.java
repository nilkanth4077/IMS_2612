package com.trial.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.trial.ims")
public class SpringIms2612Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringIms2612Application.class, args);
	}

}
