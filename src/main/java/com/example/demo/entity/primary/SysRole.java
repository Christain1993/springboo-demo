package com.example.demo.entity.primary;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/22 14:49
 */
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Data
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


}
