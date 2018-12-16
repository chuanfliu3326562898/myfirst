package com.meituan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {
    public static void print(String name){
        System.out.println(name);
        List<String> subMobileNumbersList= new ArrayList<String>();
        subMobileNumbersList.add("1");
        subMobileNumbersList.add("2");
        subMobileNumbersList.add("3");
        subMobileNumbersList.add("4");
        subMobileNumbersList.add("5");
        subMobileNumbersList.add("6");
        List<Long> userIdList = subMobileNumbersList.stream().map(mobileNumber -> {
           if(mobileNumber.equals("5")){
               return null;
           }
           return Long.parseLong(mobileNumber);
        }).filter(mobileNumber -> mobileNumber != null).collect(Collectors.toList());

        for(Long a:userIdList){
            System.out.println(a);
        }

    }

    public static void main(String []args){
        print("ljf");
    }

}
