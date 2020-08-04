package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.ClassRomRecodsMapper;
import com.xiaoyitong.app.dao.StudentStatuesMapper;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
import com.xiaoyitong.app.service.StudentRecodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.memory.LinearAllocBlock;

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
public class StudentRecodsServiceImpl implements StudentRecodsService{

    @Autowired
    ClassRomRecodsMapper classRomRecodsMapper;

    @Override
    public ServerResponse updateClassRomRecods(ClassRoomRecods T) {
        int rows=classRomRecodsMapper.updateClassRomRecods(T);
        if(rows!=0){
            return  ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByID(Integer studentID) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectById(studentID);
        return ServerResponse.createBySuccess(resualt);
    }
    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByDay(Integer studentID, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByDay(studentID,date);
        return ServerResponse.createBySuccess(resualt);
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByWeek(Integer studentID, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByWeek(studentID,date);
        return ServerResponse.createBySuccess(resualt);
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByMonth(Integer studentID, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByMonth(studentID,date);
        return ServerResponse.createBySuccess(resualt);
    }
}
