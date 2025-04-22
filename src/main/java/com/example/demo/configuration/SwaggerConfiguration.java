package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Ventas")
                        .version("1.0")
                        .description("Documentación Parcial II para Linea de Profundización III")
                        .contact(new Contact()
                                .name("Yohn Sebastián Ramírez Silva")
                                .email("ysramirez@ucundinamarca.edu.co")));
    }
}
