package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/21 9:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class kakfaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void save(){
        String message = "这是一条kafka信息";
        kafkaTemplate.send("test", "key", message);

    }
}
