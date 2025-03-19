package com.fatec.projetoAula.projeto2025.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
            .info(new Info()
                    .title("API de Projeto 2025 - Semestre 1")
                    .version("1.0")
                    .description("Documentação da API do Projeto 2025 - Semestre 1"));   
    }
    
}
