package com.kodilla.sudoku;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/sudoku/**")
                .allowedOrigins("http://localhost:8888") // Dodaj odpowiedni adres klienta
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
