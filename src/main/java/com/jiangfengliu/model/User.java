package com.jiangfengliu.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by liujiangfeng on 2017/7/7.
 */
@Data
public class User{
    @JSONField(name="userName")
    String name;

    public void initMethod(){
        this.name="ljf";
        System.out.println("init user bean ok");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
