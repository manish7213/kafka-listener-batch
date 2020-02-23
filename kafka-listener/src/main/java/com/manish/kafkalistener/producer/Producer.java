package com.manish.kafkalistener.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public void sendMessage(String message){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        this.kafkaTemplate.send(TOPIC,message);
    }

    public void sendFileToKafka(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String message = null;
        while((message = br.readLine()) != null) {
            System.out.println(message);
            this.kafkaTemplate.send(TOPIC,message);
        }
        br.close();
    }
}