package boot2.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * The type Abstract message producer.
 *
 * @param <T> the type parameter
 * @param <R> the type parameter
 */
public abstract class AbstractMessageProducer<T, R> {

    /**
     * Gets kafka template.
     *
     * @return the kafka template
     */
    protected KafkaTemplate<T, R> getKafkaTemplate() {
        return kafkaTemplate;
    }

    /**
     * Gets topic name.
     *
     * @return the topic name
     */
    protected String getTopicName() {
        return topicName;
    }

    private final KafkaTemplate<T, R> kafkaTemplate;

    private final String topicName;

    /**
     * Instantiates a new Abstract message producer.
     *
     * @param kafkaTemplate    the kafka template
     * @param kafkaTopicConfig the kafka topic config
     */
    public AbstractMessageProducer(KafkaTemplate<T, R> kafkaTemplate, KafkaTopicConfig kafkaTopicConfig) {
        this.kafkaTemplate = kafkaTemplate;
        //TODO: check!
        this.topicName = kafkaTopicConfig.getKafkaBootstrapAddress();
    }

    /**
     * Send message.
     *
     * @param message the message
     */
    public abstract void sendMessage(String message);

    /**
     * Gets send result listenable future callback.
     *
     * @param message the message
     * @return the send result listenable future callback
     */
    protected ListenableFutureCallback<SendResult<T, R>> getSendResultListenableFutureCallback(R message) {
        return new ListenableFutureCallback<SendResult<T, R>>() {

            @Override
            public void onSuccess(SendResult<T, R> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        };
    }
}

