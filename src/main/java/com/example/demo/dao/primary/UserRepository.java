package com.example.demo.dao.primary;

import com.example.demo.entity.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 14:55
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);
}
