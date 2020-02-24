package com.manish.kafkalistener.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author manish
 */
@Service
public class Consumer {

    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private static final String basePath = "C:/Users/manishkumar75/Desktop/BatchFiles/";

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info("Consumed Message is {} ",message);
        PrintWriter out = null;
        try {
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.csv'").format(new Date());
            File file = new File(basePath+fileName);
            file.createNewFile();
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                out.flush();
                out.close();
            }

        }
    }

}
