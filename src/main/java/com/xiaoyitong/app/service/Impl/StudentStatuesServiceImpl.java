package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.StudentStatuesMapper;
import com.xiaoyitong.app.pojo.StudentStatues;
import com.xiaoyitong.app.service.StudentStatuesService;
import com.xiaoyitong.app.utils.RQUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
public class StudentStatuesServiceImpl implements StudentStatuesService {

    @Autowired
    StudentStatuesMapper studentStatuesMapper;

    @Override
    public ServerResponse updateStudentStatues(StudentStatues T) {
        int rowCount=studentStatuesMapper.insert(T);
        if(rowCount>0) {
            return ServerResponse.createBySuccessMessage("上传成功");
        }else {
            return ServerResponse.createByErrorMessage("上传失败");
        }
    }

    @Override
    public String createImg(Integer student_id) {
        StudentStatues r=studentStatuesMapper.selectByPrimaryKey(student_id);
        return RQUtil.getTxt(r);
    }
}
