package com.java666.dao;

import com.java666.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Date 2020/2/10 21:03
 * @Author JianHui
 */
public interface UserRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {

//    @Query(value = "select * ")
//    List<UserInfo> findUserInfoByName(String name);
}
