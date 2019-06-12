package com.example.demo;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class DemoApplication {
	Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	RequestMappingHandlerMapping handlerMapping;
	
	@Autowired
	EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
        	 registry.addMapping("/**").allowedMethods("GET", "POST");
         }
      };
   }
      
   @EventListener(ApplicationReadyEvent.class)
   public void showInfoAfterStartup() {
       logger.info("--- Showing all controllers endpoint ---");
       for(RequestMappingInfo info : handlerMapping.getHandlerMethods().keySet()) {
           logger.info(info.toString());
       }       
   }
}
