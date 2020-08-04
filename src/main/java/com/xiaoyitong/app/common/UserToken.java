package com.xiaoyitong.app.common;

import org.springframework.stereotype.Component;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
@Component
public class UserToken {

    private String token="";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
