package boot2.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * The type Kafka base message producer.
 */
@Component
public class KafkaBaseMessageProducer extends AbstractMessageProducer<String, String> implements IKafkaMessageProducer {

    /**
     * Instantiates a new Kafka base message producer.
     *
     * @param kafkaTemplate    the kafka template
     * @param kafkaTopicConfig the kafka topic config
     */
    public KafkaBaseMessageProducer(KafkaTemplate kafkaTemplate, KafkaTopicConfig kafkaTopicConfig) {
        super(kafkaTemplate, kafkaTopicConfig);
    }

    public void sendMessage(String message) {

        var topicName = getTopicName();

        var kafkaTemplate = getKafkaTemplate();

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(getSendResultListenableFutureCallback(message));
    }
}

