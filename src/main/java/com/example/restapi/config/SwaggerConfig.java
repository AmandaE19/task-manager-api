package com.example.restapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@io.swagger.v3.oas.annotations.OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "API de Tarefas", version = "v1", description = "Documentação da API para gerenciamento de tarefas"), servers = @io.swagger.v3.oas.annotations.servers.Server(url = "http://localhost:8081"))
public class SwaggerConfig {
    // Se necessário personaliza algo mais
}
