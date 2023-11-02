package com.testtask.kafkarestdocker.controllers;


import com.testtask.kafkarestdocker.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping
    public ResponseEntity<String> publish(@RequestParam(value = "message",required = false) String message){
        if (message == null) {
            return ResponseEntity.badRequest().body("Message is required");
        } else if (message.isEmpty()) {
            return ResponseEntity.badRequest().body("Message cannot be empty");
        } else {
            kafkaProducer.sendMessage(message);
            return ResponseEntity.ok("Message sent in topic");
        }
    }
}
