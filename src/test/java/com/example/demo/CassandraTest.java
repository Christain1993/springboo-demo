//package com.example.demo;
//
//import com.example.demo.entity.cassandra.Classes;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//
///**
// * @author ：zhaoyu
// * @date ：Created in 2019/2/19 10:18
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CassandraTest {
//
//    private CassandraRepository cassandraRepository;
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void contextLoads() {
//        Classes classes = new Classes();
//        classes.setName("九年级");
//        classes.setGrade(9);
//        cassandraRepository.save(classes);
//
//    }
//}
