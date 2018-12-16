package com.meituan.model;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import static jdk.nashorn.internal.codegen.types.Type.SCOPE;

/**
 * Created by liujiangfeng on 2017/7/7.
 */
@Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class UserName {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
