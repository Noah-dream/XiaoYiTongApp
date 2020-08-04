package com.xiaoyitong.app.utils;

import com.xiaoyitong.app.dao.StudentStatuesMapper;
import com.xiaoyitong.app.pojo.StudentStatues;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class RQUtil {

//    private static String imgHealth="https://cli.im/api/qrcode/code?text=mytxt&mhid=s0TBWl3pncwhMHYuLdJcOqw";
//
//    private static String imgUnhealth="https://cli.im/api/qrcode/code?text=mytxt&mhid=t0SRCl7tmpkhMHYuLdJcOq0";

    public static String getTxt(StudentStatues T){
        if(T.getTemperature()>=37.0){
            String txt=T.getStudent_id().toString()+T.getTemperature().toString()+T.getDate().toString();
            return "https://cli.im/api/qrcode/code?text=mytxt&mhid=t0SRCl7tmpkhMHYuLdJcOq0".replace("mytxt",txt);
        }else{
            String txt=T.getStudent_id().toString()+T.getTemperature().toString()+T.getDate().toString();
            return "https://cli.im/api/qrcode/code?text=mytxt&mhid=t0SRCl7tmpkhMHYuLdJcOq0".replace("mytxt",txt);
        }
    }
}
