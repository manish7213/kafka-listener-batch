package com.manish.kafkalistener.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.io.*;

/**
 * @author manish
 */
@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${spring.kafka.topics}")
    private String topic;
    public void sendMessage(final String message){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        String topic_test = topic.split("\\\\")[0];
        this.kafkaTemplate.send( topic_test,message);
    }

    public void sendFileToKafka(final String filePath,String topic) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String message = null;
        while((message = br.readLine()) != null) {
            logger.info(message);
            this.kafkaTemplate.send(topic,message);
        }
        br.close();
    }
}