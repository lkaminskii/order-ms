package dev.lucas.order_ms.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management API")
                        .version("1.0")
                        .description("RESTful API for Order Management with RabbitMQ and AWS SQS integration")
                        .contact(new Contact()
                                .name("Lucas")
                                .email("lucaskaminskith@gmail.com)"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                            );
    }

}
