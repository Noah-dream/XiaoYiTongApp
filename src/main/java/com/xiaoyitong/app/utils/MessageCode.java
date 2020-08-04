package com.xiaoyitong.app.utils;

import java.util.Random;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class MessageCode {
    public static String creatCode(){
        String code = null;
        code=String.format("%04d",new Random().nextInt(9999));
        return code;
    }
}
