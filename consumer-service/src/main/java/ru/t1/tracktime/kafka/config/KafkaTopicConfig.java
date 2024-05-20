package ru.t1.tracktime.kafka.config;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Kafka topics.
 * This class sets up the configuration for Kafka topics, including the bootstrap servers and topic definitions.
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * The address of the Kafka bootstrap servers.
     */
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    /**
     * Creates a KafkaAdmin instance for managing Kafka topics.
     * @return KafkaAdmin instance.
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /**
     * Defines a new Kafka topic for add new trackTime.
     * @return NewTopic instance representing the user get request topic.
     */
    @Bean
    public NewTopic addTrackTime() {
        return new NewTopic("metrics-topic", 1, (short) 1);
    }
}
