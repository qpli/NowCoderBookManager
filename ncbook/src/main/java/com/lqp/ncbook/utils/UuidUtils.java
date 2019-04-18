package com.lqp.ncbook.utils;

import java.util.UUID;
/*
* 该类用来生成一串随机的字符串
* */
public class UuidUtils {
    public static String next()
    {
        return UUID.randomUUID().toString().replace("-","a");
    }
}
