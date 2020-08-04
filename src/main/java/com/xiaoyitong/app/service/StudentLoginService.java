package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.StudentLogin;
import org.springframework.stereotype.Service;

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
public interface StudentLoginService {

    ServerResponse<StudentLogin> loginById(String username, String password);

    ServerResponse<StudentLogin> loginByPhone(Integer phoneNumber,String codeInput);

    ServerResponse<String> register(StudentLogin user,String codeInput);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> restPassword(Integer phoneNumber,String codeInput,String newPassword);

    ServerResponse<StudentLogin> updateUserInfo(StudentLogin user);

    ServerResponse<StudentLogin> getUserInfo(Integer userId);

    ServerResponse checkAdminRole(StudentLogin user);

    ServerResponse<String> removeToken(String token);
}
