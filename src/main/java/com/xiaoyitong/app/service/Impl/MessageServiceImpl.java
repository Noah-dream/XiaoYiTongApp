package com.xiaoyitong.app.service.Impl;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.xiaoyitong.app.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
@Service
@Component
public class MessageServiceImpl implements MessageService {
    @Override
    public String sendMessage(Integer type,String code) {
        // 短信应用SDK AppID
        int appid = 2; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "";

        // 需要发送短信的手机号码
        String[] phoneNumbers = {""};

        // 短信模板ID，需要在短信应用中申请
        int templateId1 =2 ; //这里是修改密码
        int templateId2=2;//这里是注册
        int templateId3=6;//这里是登陆
        int templateId;
        if(type==1){
            templateId=templateId1;
        }else if(type==2){
            templateId=templateId2;
        }else{
            templateId=templateId3;
        }
        SmsSingleSenderResult result=null;
        // 签名
        String smsSign = "Noah的个人网"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

        try {
            String[] params = {code};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (Exception e) {
            // 网络IO错误
            e.printStackTrace();
        }finally {
            return code;
        }
    }
}
