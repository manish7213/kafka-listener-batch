package com.manish.kafkalistener.controller;

import com.manish.kafkalistener.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author manish
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final Producer producer;
    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
    @PostMapping(value = "/publish/file")
    public void sendFileToKafkaTopic(@RequestParam("filePath") String filePath,@RequestParam("topic") String topic) throws IOException {
        this.producer.sendFileToKafka(filePath,topic);
    }
}
