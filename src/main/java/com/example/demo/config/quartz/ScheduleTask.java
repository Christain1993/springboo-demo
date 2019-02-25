package com.example.demo.config.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTask {
    public void sayHello(){
        log.info("Hello world, i'm the king of the world!!!");
    }


    public void sayHello2(){
        System.out.println("hahahahaha helloworld");
    }
}