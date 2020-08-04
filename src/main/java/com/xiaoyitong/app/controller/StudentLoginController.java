package com.xiaoyitong.app.controller;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.StudentInfoMapper;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
import com.xiaoyitong.app.pojo.StudentLogin;
import com.xiaoyitong.app.service.MessageService;
import com.xiaoyitong.app.service.StudentLoginService;
import com.xiaoyitong.app.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.pattern.PathPattern;

import javax.servlet.http.HttpSession;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
@RestController
@RequestMapping("/app/")
public class StudentLoginController {

    @Autowired
    StudentLoginService studentLoginService;
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "loginById", method = RequestMethod.POST)
    public ServerResponse<String> loginById(@RequestParam("student_id") Integer student_id, @RequestParam("password") String password) throws Exception {
        ServerResponse<StudentLogin> loginInfo=studentLoginService.loginById(student_id.toString(),password);
        String token=JwtUtil.createToken(loginInfo.getData().getStudent_id().toString());
        return ServerResponse.createBySuccess("登陆成功",token);
    }

    @RequestMapping(value = "loginByPhone", method = RequestMethod.POST)
    public ServerResponse<String> loginByPhone(@RequestParam("phone") Integer phone,@RequestParam("codeInput") Integer codeInput ) throws Exception {
        ServerResponse<StudentLogin> T=studentLoginService.loginByPhone(phone,codeInput.toString());
        if (T.getData()!=null){
            String token=JwtUtil.createToken(T.getData().getStudent_id().toString());
            return ServerResponse.createBySuccess("登陆成功",token);
        }else{
            return ServerResponse.createByErrorMessage(T.getMsg());
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ServerResponse<String> logout(String token){
        return studentLoginService.removeToken(token);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ServerResponse<String> register(@RequestParam("regisInfo") StudentLogin studentLogin,@RequestParam("codeInput") Integer codeInput ) {
        return studentLoginService.register(studentLogin,codeInput.toString());
    }

    @RequestMapping(value = "restPassword", method = RequestMethod.POST)
    public ServerResponse<String> restPassword(@RequestParam("phone") Integer phone
                                                ,@RequestParam("codeInput") String code
                                                ,@RequestParam("password") String password){
       return studentLoginService.restPassword(phone,code,password);
    }

}
