package com.api.backfotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@SpringBootApplication
@RestController
@EntityScan(basePackages = "com.api.backfotos.models")
public class BackFotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackFotosApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}
}
