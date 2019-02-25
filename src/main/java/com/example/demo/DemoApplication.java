package com.example.demo;

import com.example.demo.entity.primary.User;
import com.example.demo.entity.secondary.RoleEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PersistenceContext(unitName = "primaryPersistenceUnit")
    private EntityManager primaryEntityManger;

    @PersistenceContext(unitName = "secondaryPersistenceUnit")
    private EntityManager secondaryEntityManger;

    @Transactional
    @Modifying
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public void insertUser(){
        User user = new User();
        user.setUsername("小明");
        primaryEntityManger.persist(user);
    }

    @Transactional
    @Modifying
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public void insertRole(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("student");
        secondaryEntityManger.persist(roleEntity);
        System.out.println(roleEntity);
    }


    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public void getRole(@PathVariable Long id){

    }


}
