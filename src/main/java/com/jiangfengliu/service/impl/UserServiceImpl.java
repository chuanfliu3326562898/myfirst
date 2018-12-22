package com.jiangfengliu.service.impl;
import javax.annotation.Resource;

import com.jiangfengliu.aspect.SpringLogAround;
import com.jiangfengliu.util.TestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiangfengliu.mapper.UserMapper;
import com.jiangfengliu.model.User;
import com.jiangfengliu.service.UserService;

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
    //@SpringLogAround(interfaceDesc = "UserServiceImpl findNameById")
    @SpringLogAround(interfaceDesc = "LogDescriptionAround findNameById")
    public User findNameById(int id) {
       TestUtil.print("UserServiceImpl findNameById is processing");
        //User user = mapper.findNameById(id);
       User user =new User();
       user.setName("12");
       return user;
    }
//  public static  void main (String []args)
//  {
//    //List<String>mobileNumbers= Lists.newArrayList();
//    System.out.println(StringUtils.isNumeric("233.1"));
//    for(int i=0;i<5;i++){
//      Double amount;
//      try {
//        System.out.println(i);
//        if(i%2==0){
//          throw new NumberFormatException();
//        }
//      } catch (NumberFormatException e) {
//
//        continue;
//      }
//      System.out.println(i);
//    }
//  }
  public static void main(String[] args) {
    if("".matches("^0+$")){
      System.out.println("true");
    }
  }
}
