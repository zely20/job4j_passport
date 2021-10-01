package ru.jo4j.passport.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> template;

    @KafkaListener(topics = {"message"})
    public void onApiCall(String data) {
            template.send("message", data);
        }
    }
