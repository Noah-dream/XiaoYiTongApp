package com.xiaoyitong.app.utils;

import redis.clients.jedis.Jedis;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class RedisUtil {
    public static Jedis getConnect(String url,int port,String password){
        Jedis jedis=new Jedis(url,port);
        jedis.auth(password);
        return jedis;
    }
}
