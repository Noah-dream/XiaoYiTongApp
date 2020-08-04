package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.StudentLeaveMapper;
import com.xiaoyitong.app.pojo.StudentLeave;
import com.xiaoyitong.app.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
public class StudentLeaveServiceImpl implements StudentLeaveService {

    @Autowired
    StudentLeaveMapper studentLeaveMapper;

    @Override
    public ServerResponse update(StudentLeave T) {
        int rowCow=studentLeaveMapper.updateByPrimaryKey(T);
        if(rowCow>0){
            return ServerResponse.createBySuccessMessage("上传成功");
        }else{
            return ServerResponse.createByErrorMessage("上传失败");
        }
    }

    @Override
    public ServerResponse<List<StudentLeave>> selectByID(Integer studentID) {
        List<StudentLeave> resualt;
        resualt=studentLeaveMapper.selectById(studentID);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }

    }

    @Override
    public ServerResponse<List<StudentLeave>> selectByDay(Integer studentID, Date date) {
        List<StudentLeave> resualt;
        resualt=studentLeaveMapper.selectByDay(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<StudentLeave>> selectByWeek(Integer studentID, Date date) {
        List<StudentLeave> resualt;
        resualt=studentLeaveMapper.selectByWeek(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<StudentLeave>> selectByMonth(Integer studentID, Date date) {
        List<StudentLeave> resualt;
        resualt=studentLeaveMapper.selectByMonth(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

}
