package com.spring.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.collect.Lists;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@SecurityScheme(
        name = "JWT", // can be set to anything
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT", scheme = "bearer"
)
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "Customer accounts API", version = "1.0.0"),
        security = @SecurityRequirement(name = "JWT") // references the name defined in the line 3
)
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components())
                // Thiết lập các server dùng để test api
                .servers(Lists.newArrayList(
                        new Server().url(("https://new-monstar-lab.herokuapp.com/")),
                        new Server().url("http://localhost:9090")
                ))
                // info
                .info(new Info().title("Customer accounts API")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .version("1.0.0"));
    }
}
