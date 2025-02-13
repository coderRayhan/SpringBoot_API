package com.hrm.smartHR.config;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiDocumentationConfig {

    @Bean
    public OpenAPI swaggerConfig() {
        List<Server> serverList = new ArrayList<>();
        Server productionServer = new Server();
        productionServer.setUrl("http://localhost:8080");
        productionServer.setDescription("Production Server");

        Server developmentServer = new Server();
        developmentServer.setUrl("http://localhost:8080");
        developmentServer.setDescription("Development Server");
        serverList.add(productionServer);
        serverList.add(developmentServer);
        return new OpenAPI().info(
                        new Info().title("SmartHR APIs")
                                .description("By Rayhan")
                )
                .servers(serverList);
    }
}
