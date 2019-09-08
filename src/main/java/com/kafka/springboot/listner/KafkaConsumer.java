package com.kafka.springboot.listner;

import com.kafka.springboot.model.User;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Hello-Kafka", groupId = "group_id")
    public void consume(String message) {
        log.info("Consumed message: "+ message);
    }

    @KafkaListener(topics = "Hello-Kafka-Json", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeJson(User user){
        log.info("Consumed Json: " + user.toString());
    }
}
