package com.example.book.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Book",
                description = "Interaction with books", version = "2.6.0",
                contact = @Contact(
                        name = "Anastasia",
                        email = "n.bogocharova@gmail.com"
                )
        )
)
public class OpenApiConfig {

}


