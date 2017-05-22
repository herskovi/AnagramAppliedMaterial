package com.amat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication(scanBasePackages={"com.amat"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@Configuration
@EnableCaching
public class AnagramApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(AnagramApplication.class, args);
	}
}
