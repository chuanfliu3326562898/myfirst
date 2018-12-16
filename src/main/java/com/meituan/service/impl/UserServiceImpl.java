package com.meituan.service.impl;
import javax.annotation.Resource;

import com.meituan.aspect.LogDescriptionAround;
import com.meituan.aspect.SpringLogAround;
import com.meituan.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meituan.mapper.UserMapper;
import com.meituan.model.User;
import com.meituan.service.UserService;

import java.io.Serializable;

/**
 * Created by liujiangfeng on 2017/7/17.
 */
@Service
@Transactional(value = "transactionManager", rollbackFor = {Exception.class})
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper mapper;

    /**
     * 根据 id 查询 对应数据
     */
    @SpringLogAround(interfaceDesc = "UserServiceImpl findNameById")
    public User findNameById(int id) {
        System.out.println("test begin");
        TestUtil.print("ljf");
        //User user = mapper.findNameById(id);
       User user =new User();
       user.setName("12");
        return user;
    }
//    public static  void main (String []args)
//    {
//        System.out.println("ok");
//    }
}
