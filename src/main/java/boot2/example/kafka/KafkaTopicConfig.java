package boot2.example.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kafka topic config.
 */
/*@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    *//**
     * Gets kafka bootstrap address.
     *
     * @return the kafka bootstrap address
     *//*
    public String getKafkaBootstrapAddress() {
        return bootstrapAddress;
    }

    *//**
     * Kafka admin kafka admin.
     *
     * @return the kafka admin
     *//*
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    *//**
     * Topic 1 new topic.
     *
     * @return the new topic
     *//*
    @Bean
    public NewTopic topic1() {
        return new NewTopic("test_kafka", 1, (short) 1);
    }
}*/
