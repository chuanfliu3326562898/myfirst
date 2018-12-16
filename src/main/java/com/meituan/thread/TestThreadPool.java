package com.meituan.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class TestThreadPool {
    private static final ThreadLocalCache<String,Object> threadLocal = new ThreadLocalCache();
    public TestThreadPool() {
    }
    public static void main(String[]args){
        Integer a=-1;
        System.out.println(Integer.toBinaryString(a<<29));
        System.out.println(a);
    }
}
