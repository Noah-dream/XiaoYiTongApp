package com.xiaoyitong.app.service.Impl;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.dao.MailBoxMapper;
import com.xiaoyitong.app.pojo.MailBox;
import com.xiaoyitong.app.pojo.StudentLeave;
import com.xiaoyitong.app.service.MailBoxService;
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
public class MailBoxServiceImpl implements MailBoxService {

    @Autowired
    MailBoxMapper mailBoxMapper;

    @Override
    public ServerResponse updateSituation(Integer id) {
        int row=mailBoxMapper.updateStiuation(id);
        if(row!=0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<MailBox>> selectByID(Integer studentID) {
        List<MailBox> resualt;
        resualt= mailBoxMapper.selectById(studentID);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<MailBox>> selectByDay(Integer studentID, Date date) {
        List<MailBox> resualt;
        resualt= mailBoxMapper.selectByDay(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<MailBox>> selectByWeek(Integer studentID, Date date) {
        List<MailBox> resualt;
        resualt= mailBoxMapper.selectByWeek(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<MailBox>> selectByMonth(Integer studentID, Date date) {
        List<MailBox> resualt;
        resualt= mailBoxMapper.selectByMonth(studentID,date);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<List<MailBox>> selectBySituation(Integer studentID) {
        List<MailBox> resualt;
        resualt= mailBoxMapper.selectBySituation(studentID);
        if(resualt!=null){
            return ServerResponse.createBySuccess(resualt);
        }else{
            return ServerResponse.createByError();
        }
    }
}
