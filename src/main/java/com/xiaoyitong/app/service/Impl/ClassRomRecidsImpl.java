package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.ClassRomRecodsMapper;
import com.xiaoyitong.app.dao.StudentStatuesMapper;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
import com.xiaoyitong.app.pojo.MailBox;
import com.xiaoyitong.app.pojo.StudentStatues;
import com.xiaoyitong.app.service.ClassRomRecidsService;
import com.xiaoyitong.app.service.StudentStatuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
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
public class ClassRomRecidsImpl implements ClassRomRecidsService {

    @Autowired
    ClassRomRecodsMapper classRomRecodsMapper;
    @Autowired
    StudentStatuesMapper studentStatuesMapper;

    @Override
    public ServerResponse<String> updateClassRomRecods(ClassRoomRecods t) {
        int id=t.getStudent_id();
        List<StudentStatues> resualt=studentStatuesMapper.selectById(id);
        double temp=resualt.get(0).getTemperature();
        if(temp>37){
            return ServerResponse.refuseCreate("体温异常不可进入");
        }else {
            int rows = classRomRecodsMapper.updateClassRomRecods(t);
            if (rows != 0) {
                return ServerResponse.createBySuccess("允许进入");
            } else {
                return ServerResponse.createByErrorMessage("进入失败");
            }
        }
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectById(Integer student_id) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectById(student_id);
        return ServerResponse.createBySuccess(resualt);
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByDay(Integer student_id, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByDay(student_id,date);
        return ServerResponse.createBySuccess(resualt);
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByWeek(Integer student_id, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByWeek(student_id,date);
        return ServerResponse.createBySuccess(resualt);
    }

    @Override
    public ServerResponse<List<ClassRoomRecods>> selectByMonth(Integer student_id, Date date) {
        List<ClassRoomRecods> resualt;
        resualt=classRomRecodsMapper.selectByMonth(student_id,date);
        return ServerResponse.createBySuccess(resualt);
    }
}
