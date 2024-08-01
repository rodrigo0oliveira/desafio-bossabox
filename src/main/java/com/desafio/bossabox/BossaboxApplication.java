package com.desafio.bossabox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Desafio Bossabox",version = "1",description = "API desenvolvida para o desafio de ferramentas" ))
public class BossaboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossaboxApplication.class, args);
	}

}
