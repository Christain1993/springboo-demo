package com.example.demo;

import com.example.demo.dao.primary.UserRepository;
import com.example.demo.dao.secondary.RoleRepository;
import com.example.demo.entity.primary.User;
import com.example.demo.entity.secondary.RoleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @PersistenceContext(unitName = "primaryPersistenceUnit")
    private EntityManager primaryEntityManger;

    @PersistenceContext(unitName = "secondaryPersistenceUnit")
    private EntityManager secondaryEntityManger;

    @Autowired
    private RoleRepository roleRepository ;

    @Autowired
    private UserRepository userRepository ;

    @Test
    @Transactional
    @Rollback(false)
    public void contextLoads() {
        User user = new User();
        user.setUsername("李华");
        User save = userRepository.save(user);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void secondaryTest(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("student");
        RoleEntity save = roleRepository.save(roleEntity);
        System.out.println(save);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void secondaryEntityMangerTest(){
        RoleEntity entity = new RoleEntity();
        entity.setName("teacher");

        secondaryEntityManger.persist(entity);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void getFromSecondary(){
        RoleEntity roleEntity = secondaryEntityManger.find(RoleEntity.class, 1L);
        roleEntity.setName("admin");
        System.out.println("=========");
        System.out.println(roleEntity);
        roleRepository.save(roleEntity);
    }

}
