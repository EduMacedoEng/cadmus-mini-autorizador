package br.com.cadmus.miniautorizador.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cadmus Miniautorizador")
                        .description("Documentação Swagger Cadmus Miniautorizador")
                        .version("1.0.0"));
    }
}
