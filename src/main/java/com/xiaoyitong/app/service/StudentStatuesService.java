package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.StudentStatues;
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
public interface StudentStatuesService {

    ServerResponse updateStudentStatues(StudentStatues T);

    String createImg(Integer student_id);
}
