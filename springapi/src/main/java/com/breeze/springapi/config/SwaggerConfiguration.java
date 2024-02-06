package com.breeze.springapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
                    info = @Info(
                                    title = "Spring Boot API 명세서",
                                    description = "Breeze08 Service RestFul API 명세서",
                                    version = "v1.0"
                                )
)

// 접속 경로 : http://localhost:8080/swagger-ui/index.html
public class SwaggerConfiguration {

}