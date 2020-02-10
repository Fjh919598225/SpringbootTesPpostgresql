package com.java666.service.impl;

import com.java666.dao.UserRepository;
import com.java666.entity.UserInfo;
import com.java666.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Date 2020/2/10 21:05
 * @Author JianHui
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    @Override
    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public UserInfo query(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public void delete(Integer id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<UserInfo> list(UserInfo userInfo, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable =  PageRequest.of(page-1, pageSize, direction, properties);
        Page<UserInfo> pageUser = userRepository.findAll(new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (userInfo != null) {
                    if (userInfo.getName() != null && userInfo.getName() != "") {
                        predicate.getExpressions().add(cb.like(root.get("name"), "%" + userInfo.getName() + "%"));
                    }
                }
                return predicate;
            }
        }, pageable);

        return pageUser.getContent();
    }


}
