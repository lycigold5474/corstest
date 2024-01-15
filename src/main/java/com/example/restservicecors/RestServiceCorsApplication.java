package com.example.restservicecors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestServiceCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceCorsApplication.class, args);
	}

	/**
	 * 글로벌하게 설정할때 사용 컨트롤러 메소드에만 설정 할 수도 있음 (컴트롤러 참조)
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9001");
			}
		};
	}
}
