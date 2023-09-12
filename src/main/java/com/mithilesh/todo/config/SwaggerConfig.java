package com.mithilesh.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                        .title("ToDo List API")
                        .description("API for ToDo list app developed by Mithilesh Shah")
                        .version("1.0.0")
                        .contact(new Contact().name("Mithilesh Shah").email("mithileshkshah@gmail.com")));
    }
}
