package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 17:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void save(){
        String key = "haha";
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            System.out.println(redisTemplate.opsForValue().get(key));
        }else{
            redisTemplate.opsForValue().set(key,"hehe");
        }

    }

}
