package com.springBoot.babel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import util.JPAUtil;

@SpringBootApplication(scanBasePackages = {"com.springBoot.babel", "config, controllers"})
public class SpringBootTheLibraryOfBabelApplication implements WebMvcConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTheLibraryOfBabelApplication.class, args);
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
	}	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/books");
	}

	
}
	