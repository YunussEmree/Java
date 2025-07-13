package com.yunussemree.KafkaDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = KafkaConfig.TOPIC, groupId = "demo-group")
    public void listen(String message) {
        log.info("🎧 Mesaj tüketildi: {}", message);
    }
}
