package com.example.demo.entity.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 16:11
 */
@Document(collection = "message")
@Data
public class MessageDocument {

    private Long fromUserId;
    private Long toUserId;
    private String message;


}
