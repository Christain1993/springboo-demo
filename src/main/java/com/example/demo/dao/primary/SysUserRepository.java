package com.example.demo.dao.primary;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/22 14:51
 */

import com.example.demo.entity.primary.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
