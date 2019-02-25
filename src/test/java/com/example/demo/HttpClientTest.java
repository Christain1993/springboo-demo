package com.example.demo;

import com.example.demo.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/20 17:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTest {

    @Test
    public void save(){
        String s = HttpClientUtils.doGet("http://www.baidu.com");
        System.out.println(s);

    }
}
