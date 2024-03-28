package com.liying.springboot3kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*kafkaAutConfiguration提供如下功能
1、kafkaProperties：kafka所有配置  以spring-kafka开始
-bootstrpServers： kafka集群的服务器地址
-properties：参数设置
-consumer：消费者
-producer：生产者

2、@Enablekafka： 开启kafka的注解驱动功能
3、kafkaTemplate：收发消息
4、kafkaAdmin: 维护主题等kafka的内部东西*/





@SpringBootApplication
public class Springboot3KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3KafkaApplication.class, args);
    }

}
