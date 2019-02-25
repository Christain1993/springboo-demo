package com.example.demo;

import com.example.demo.dao.document.MessageRepository;
import com.example.demo.entity.document.MessageDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void save(){
        MessageDocument messageDocument = new MessageDocument();
        messageDocument.setFromUserId(1L);
        messageDocument.setToUserId(2L);
        messageDocument.setMessage("呵呵");
        messageRepository.save(messageDocument);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void get(){
        List<MessageRepository> list = messageRepository.getByMessageLike("哈");
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void query(){
        List<MessageRepository> list = messageRepository.findByFromId(1L);
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void queryNative(){
        List<MessageRepository> list = messageRepository.QueryByMessageLike("哈");
        System.out.println(list);
    }


}
