package com.meituan.mapper;
  
import java.util.List;  
  
import com.meituan.model.User;
/** 
 * 做为 DAO的接口
 * 在mybatis中 mapper就相当于dao
 * @author */  
public interface UserMapper {    
//    void save(UserName user);
//    boolean update(UserName user);
//    boolean delete(int id);
    User findNameById(int id);
//    List<UserName> findAll();
}