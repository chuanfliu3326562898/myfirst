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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        TestUtil.print("ljf");
        //User user = mapper.findNameById(id);
       User user =new User();
       user.setName("12");
        return user;
    }
    public static  void main (String []args)
    {
//        List<String>mobileNumbers=new ArrayList<>();
//        mobileNumbers.add("1");
//        mobileNumbers.add("2");
//        mobileNumbers.add("3");
//        mobileNumbers.add("4");
//        mobileNumbers.add("5");
//
//        List<Long>mobileNumbers
//        List<Long> userIdListTmp = mobileNumbers.stream().map(mobileNumber -> {
//           if(Long.parseLong(mobileNumber)%2==0){
//
//           }else{
//               return Long.parseLong(mobileNumber);
//           }
//        });
//        System.out.println("ok");
        Long tmp=2L;
        System.out.println(String.valueOf(tmp));
    }
}
