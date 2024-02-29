package com.tutorial.springbootkafka.controller;

import com.tutorial.springbootkafka.kafka.JsonKafkaProducer;
import com.tutorial.springbootkafka.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@AllArgsConstructor
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic!");
    }

}
