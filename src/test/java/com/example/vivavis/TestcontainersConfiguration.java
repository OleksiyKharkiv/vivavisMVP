package com.example.vivavis;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withDatabaseName("vivavis_db")
                .withUsername("User")
                .withPassword("");
        container.start();
        return container;
    }

    @Bean
    @ServiceConnection
    RabbitMQContainer rabbitContainer() {
        RabbitMQContainer container = new RabbitMQContainer(DockerImageName.parse("rabbitmq:latest"));
        container.start();  // Запуск контейнера RabbitMQ
        return container;
    }
}
