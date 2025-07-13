package com.yunussemree.KafkaDemo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    public static final String TOPIC = "demo-topic";

    @Bean
    public NewTopic demoTopic() {
        // 1 bölüm, replika sayısı 1
        return new NewTopic(TOPIC, 1, (short) 1);
    }
}