package boot2.example.kafka;

/**
 * The interface Kafka message producer.
 */
public interface IKafkaMessageProducer {

    /**
     * Send message.
     *
     * @param message the message
     */
    void sendMessage(String message);
}
