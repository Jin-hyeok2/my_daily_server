package com.example.my_diary_project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
            .info(new Info().title("diaryForGroup API")
                .description("다중 프로필 SNS API 명세서입니다.")
                .version("v0.0.1"));
    }
}
