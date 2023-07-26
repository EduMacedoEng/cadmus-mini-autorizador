package br.com.cadmus.miniautorizador.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.cadmus.miniautorizador.repository.mongo")
@EnableJpaRepositories(basePackages = "br.com.cadmus.miniautorizador.repository.jpa")
public class DatabaseConfiguration {
}
