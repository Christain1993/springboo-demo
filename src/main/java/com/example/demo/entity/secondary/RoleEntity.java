package com.example.demo.entity.secondary;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 11:30
 */
@Entity
@Table(name = "role")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name ;

}
