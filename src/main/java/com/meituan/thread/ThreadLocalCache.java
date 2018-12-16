package com.meituan.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalCache<K,V> extends ThreadLocal<ConcurrentHashMap>{
    public void set(K key,V value){
        if(super.get()!=null){
            super.get().put(key,value);
        }
    }
    public  V get(K key){
        if(super.get()!=null){
            super.get().get(key);
        }
        return null;
    }

    public void clearCurrentThread(){
        super.get().clear();
    }

    /**
     * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
     */
    @Override
    protected ConcurrentHashMap initialValue() {
        System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
        return new ConcurrentHashMap<K,V>(32);
    }
}
