package com.testtask.kafkarestdocker.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    //Logger to sout message in console
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String msg){
        LOGGER.info(String.format("Messasge sent %s ",msg));
        kafkaTemplate.send("test",msg);
    }
}
