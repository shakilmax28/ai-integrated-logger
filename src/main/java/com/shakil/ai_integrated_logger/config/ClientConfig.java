package com.shakil.ai_integrated_logger.config;

import com.google.genai.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public Client client(){
        return Client.builder().apiKey(System.getenv("GEMINI_API_KEY")).build();
    }
}
