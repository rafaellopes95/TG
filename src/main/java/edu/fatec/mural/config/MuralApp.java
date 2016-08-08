package edu.fatec.mural.config;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
 * SpringBootApplication adiciona essas annotations:
 * 
 * @Configuration --> scanea essa classe por configs
 * 
 * @ComponentScan --> scanea anotações nas classes (bean, repository, service)
 * 
 * @EnableWebMvc
 * 
 * @EnableAutoConfiguration --> tells Spring Boot to start adding beans based on
 * classpath settings, other beans, and various property settings.
 *
 */
@ComponentScan(basePackages = { "edu.fatec.mural.controller", "edu.fatec.mural.config" })
@RestController
public class MuralApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MuralApp.class, args);
	}
}
