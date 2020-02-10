package com.java666.controller;

import com.java666.common.DataGridView;
import com.java666.entity.UserInfo;
import com.java666.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Date 2020/2/10 21:05
 * @Author JianHui
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 新增或者修改
     * @param userInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public DataGridView save(UserInfo userInfo){
        userInfoService.save(userInfo);
        return new  DataGridView(200,"成功","null");
    }

    /**
     * 查找是否存在
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/existsById", method = RequestMethod.POST)
    public DataGridView existsById(Integer id){
        boolean query = userInfoService.existsById(id);
        return new DataGridView(query);
    }


    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/query", method = RequestMethod.POST)
    public String query(Integer id){
        UserInfo userInfo = userInfoService.query(id);
        if (userInfo!=null){
            return userInfo.toString();
        }else {
            return null;
        }
    }


    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public DataGridView  delete(Integer id){
       userInfoService.delete(id);
       return new DataGridView(true);
    }


    /**
     * 分页模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list")
    public void list(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("小");
        List<UserInfo> userInfoList = userInfoService.list(userInfo, 1, 10, Sort.Direction.DESC, "id");
        for (UserInfo userInfo1:userInfoList) {
            System.out.println(userInfo1.toString());
        }
    }

}
