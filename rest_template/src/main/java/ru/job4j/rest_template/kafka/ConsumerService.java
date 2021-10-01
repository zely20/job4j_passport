package ru.job4j.rest_template.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "message")
    public void consume(String message){
        System.out.println("Consuming the passport: " + message);
    }
}
