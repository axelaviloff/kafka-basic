package com.example.kafkaconsumer.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) {
        System.out.println(topicName);
        System.out.println(payload.key());
        System.out.println(payload.headers());
        System.out.println(payload.partition());
        System.out.println(payload.value());
    }
}
