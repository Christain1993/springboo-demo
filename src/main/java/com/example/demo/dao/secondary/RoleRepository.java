package com.example.demo.dao.secondary;

import com.example.demo.entity.secondary.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/18 14:55
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long>, JpaSpecificationExecutor<RoleEntity> {

}
