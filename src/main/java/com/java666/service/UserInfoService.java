package com.java666.service;

import com.java666.entity.UserInfo;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Date 2020/2/10 21:04
 * @Author JianHui
 */
public interface UserInfoService {

    /**
     * 增加或者修改
     * @param userInfo
     */
    public void save(UserInfo userInfo);

    /**
     * 根据Id查询是否存在
     * @param id
     * @return
     */
    public boolean existsById(Integer id);

    /**
     * 根据id查询实体
     * @return
     */
    public UserInfo query(Integer id);

    public void delete(Integer id);

    public List<UserInfo> list(UserInfo userInfo, Integer page, Integer pageSize, Sort.Direction direction, String... properties);

}
