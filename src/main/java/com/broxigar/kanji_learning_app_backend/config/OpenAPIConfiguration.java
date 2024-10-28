package com.broxigar.kanji_learning_app_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kanji Learning App Backend API")
                        .version("1.0")
                        .description("API documentation for the Kanji Learning App Backend"))
                .servers(List.of(new Server().url("http://localhost:8082").description("Local Server")));
    }

    @Bean
    public GroupedOpenApi kanjiApi() {
        return GroupedOpenApi.builder()
                .group("kanji")
                .pathsToMatch("/api/kanji/**")
                .build();
    }
}
