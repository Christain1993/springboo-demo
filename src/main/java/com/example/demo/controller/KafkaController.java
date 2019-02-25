package com.example.demo.controller;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/21 9:53
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(String message) {
        try {
            kafkaTemplate.send("test", "key", message);
            return "success";
        } catch (Exception e) {
            return "false";
        }
    }

}
