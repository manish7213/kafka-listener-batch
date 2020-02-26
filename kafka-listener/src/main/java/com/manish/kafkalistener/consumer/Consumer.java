package com.manish.kafkalistener.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author manish
 */
@Service
public class Consumer {

    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    @Value("${csv.outputFileBaseLocation}")
    private String outputFileBaseLocation;
    @KafkaListener(topics = "#{'${spring.kafka.topics}'.split('\\\\ ')}",groupId = "group_id")
    public void consume(String message) {
        LOGGER.info("Consumer Starts");
        if (!message.isEmpty()) {
            LOGGER.info("Consumed Message is {} ", message);
        PrintWriter out = null;
        try {
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.csv'").format(new Date());
            File file = new File(outputFileBaseLocation + fileName);
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    } else {
            LOGGER.warn("Consumed message seems to be empty");
        }
    }

}
