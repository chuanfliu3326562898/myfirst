package com.jiangfengliu.service;

import com.jiangfengliu.model.User;


/**
 * Created by liujiangfeng on 2017/7/17.
 */
public interface UserService {

//        void save(UserName user);
//        boolean update(UserName user);
//        boolean delete(int id);
//        List<UserName> findAll();
        User findNameById(int id);

}
