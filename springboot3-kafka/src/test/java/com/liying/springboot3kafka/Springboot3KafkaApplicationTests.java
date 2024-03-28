package com.liying.springboot3kafka;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
class Springboot3KafkaApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;


    @Test
    void contextLoads() throws IOException {
        StopWatch time = new StopWatch();

        CompletableFuture[] futures = new CompletableFuture[80000];
        time.start();
        for (int i = 0; i < 80000; i++) {
            CompletableFuture future = kafkaTemplate.send("kafka-topic", "发送消息", "消息入库的序号+" + i);
            futures[i] = future;
        }
        CompletableFuture.allOf(futures)
                .join();
        time.stop();
        long timeUsed = time.getTotalTimeMillis();
        System.out.println("8万条消息发送完成的时间===" + timeUsed + " 毫秒");


    }

}
