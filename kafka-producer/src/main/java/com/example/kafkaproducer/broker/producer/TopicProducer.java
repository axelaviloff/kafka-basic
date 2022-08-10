package com.example.kafkaproducer.broker.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;


    private final KafkaTemplate<String, String> kafkaTemplate;

    public TopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        System.out.println("Payload enviado: {}" + message);
        kafkaTemplate.send(topicName, message);
    }
}
