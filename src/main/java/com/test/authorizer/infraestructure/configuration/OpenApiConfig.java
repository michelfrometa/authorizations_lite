package com.test.authorizer.infraestructure.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class OpenApiConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Mini Authorizer API")
                .version("1.0.0")
                .license(new License()
                        .name("Apache License Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact()
                        .name("Michel Lázaro Frómeta Burey")
                        .email("michafrometa@gmail.com"));
    }
}
