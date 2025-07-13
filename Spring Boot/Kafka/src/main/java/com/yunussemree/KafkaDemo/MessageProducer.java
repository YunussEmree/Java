package com.yunussemree.KafkaDemo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, String> kafka;

    public MessageProducer(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    public void send(String message) {
        kafka.send(KafkaConfig.TOPIC, message);
    }
}
