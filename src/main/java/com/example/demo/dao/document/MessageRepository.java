package com.example.demo.dao.document;

import com.example.demo.entity.document.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 16:15
 */
public interface MessageRepository extends MongoRepository<MessageDocument,Long> {

    List<MessageRepository> getByMessageLike(String message);

    @Query(value = "{\"fromUserId\":?0}") // mongodb 参数序号是从0开始的
    List<MessageRepository> findByFromId(Long fromId);

    @Query(value = "{\"message\":{\"$regex\":?0}}") // mongodb 参数序号是从0开始的
    List<MessageRepository> QueryByMessageLike(String message);
}
