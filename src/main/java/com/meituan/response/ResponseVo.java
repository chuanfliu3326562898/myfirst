package com.meituan.response;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResponseVo<K,V> {
    Map<K,V> result=new HashMap<K, V>();

    public ResponseVo(K key,V value){
        result.put(key,value);
    }

    public void put(K key,V value){
        result.put(key,value);
    }



    public Object get(K key) {
        return result.get(key);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
