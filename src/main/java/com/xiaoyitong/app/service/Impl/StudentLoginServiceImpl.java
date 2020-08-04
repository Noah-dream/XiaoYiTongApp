package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.StudentLoginMapper;
import com.xiaoyitong.app.pojo.StudentLogin;
import com.xiaoyitong.app.service.MessageService;
import com.xiaoyitong.app.service.StudentLoginService;
import com.xiaoyitong.app.utils.MD5Util;
import com.xiaoyitong.app.utils.MessageCode;
import com.xiaoyitong.app.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
@Service
@Component
public class StudentLoginServiceImpl implements StudentLoginService {

    @Autowired
    StudentLoginMapper studentLoginMapper;

    @Autowired
    MessageService messageService;

    @Override
    public ServerResponse<StudentLogin> loginById(String username, String password) {
        StudentLogin studentLogin=studentLoginMapper.selectByPrimaryKey(Integer.parseInt(username));
        if(studentLogin==null){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        String md5Password= MD5Util.MD5Encodeutf8(password);
        if(md5Password.equals(studentLogin.getPassword())){
            return ServerResponse.createBySuccess("登陆成功",studentLogin);
        }else{
            return ServerResponse.createByErrorMessage("密码错误");
        }
    }

    @Override
    public ServerResponse<StudentLogin> loginByPhone(Integer phoneNumber,String codeInput) {
        int phone=studentLoginMapper.selectPhone(phoneNumber);
        String code=messageService.sendMessage(3,MessageCode.creatCode());
        if(phone==phoneNumber){
            if(code.equals(codeInput)){
                StudentLogin studentLogin=studentLoginMapper.selectByPhone(phoneNumber);
                return ServerResponse.createBySuccess("登陆成功",studentLogin);
            }else{
                return ServerResponse.createByErrorMessage("验证码错误");
            }
        }else{
            return ServerResponse.createByErrorMessage("该用户不存在");
        }
    }

    @Override
    public ServerResponse<String> register(StudentLogin user,String codeInput) {
        String code=messageService.sendMessage(2,MessageCode.creatCode());
        if(code.equals(codeInput)){
            StudentLogin studentLogin=studentLoginMapper.selectByPrimaryKey(user.getStudent_id());
            if(user!=studentLogin){
                user.setPassword(MD5Util.MD5Encodeutf8(user.getPassword()));
                int rows=studentLoginMapper.insert(user);
                if(rows==0) {
                    return ServerResponse.createByErrorMessage("注册失败");
                }else{
                    return ServerResponse.createBySuccessMessage("注册成功");
                }
            }else{
                return ServerResponse.createByErrorMessage("用户已存在");
            }
        }else{
            return ServerResponse.createByErrorMessage("验证码错误");
        }

    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        int res=0;
        if("phone".equals(type)){
            if(studentLoginMapper.selectPhone(Integer.parseInt(str))!=-1){
                return ServerResponse.createByErrorMessage("手机号已存在");
            }else{
                return ServerResponse.createBySuccessMessage("可以注册");
            }
        }else{
            if(studentLoginMapper.selectStudentID(Integer.parseInt(str))!=-1){
                return ServerResponse.createByErrorMessage("学号已存在");
            }else{
                return ServerResponse.createBySuccessMessage("可以注册");
            }
        }
    }

    @Override
    public ServerResponse<String> restPassword(Integer phoneNumber,String codeInput,String newPassword) {
        StudentLogin studentLogin=studentLoginMapper.selectByPhone(phoneNumber);
        String code=messageService.sendMessage(1,MessageCode.creatCode());
        if(code.equals(codeInput)){
            studentLoginMapper.updatePasswordByPhone(phoneNumber,newPassword);
            return ServerResponse.createBySuccessMessage("密码修改成功");
        }else{
            return ServerResponse.createByErrorMessage("验证码不正确");
        }
    }

    @Override
    public ServerResponse<StudentLogin> updateUserInfo(StudentLogin user) {
        return null;
    }

    @Override
    public ServerResponse<StudentLogin> getUserInfo(Integer userId) {
        return null;
    }

    @Override
    public ServerResponse checkAdminRole(StudentLogin user) {
        return null;
    }

    @Override
    public ServerResponse removeToken(String token) {
        String URL="106.14.142.60";
        String password="197212q";
        int port=6379;
        Jedis jedis= RedisUtil.getConnect(URL,port,password);
        jedis.set(token,"disable");
        return ServerResponse.createBySuccessMessage("成功登出");
    }
}
