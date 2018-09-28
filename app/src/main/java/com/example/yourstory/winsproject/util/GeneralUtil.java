package com.example.yourstory.winsproject.util;

/**
 * Created by lenovo on 2018/9/28.
 */

public class GeneralUtil {


    public static boolean isEmailAddress(String address){
        String regex="\\w+@\\w+\\.\\w+";
        if (address.matches(regex)){
            return true;
        }else {
            return false;
        }
    }
}
