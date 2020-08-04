package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.MailBox;
import com.xiaoyitong.app.pojo.StudentLeave;
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
public interface MailBoxService {

    ServerResponse updateSituation(Integer id);

    ServerResponse<List<MailBox>> selectByID(Integer studentID);

    ServerResponse<List<MailBox>> selectByDay(Integer studentID, Date date);

    ServerResponse<List<MailBox>> selectByWeek(Integer studentID, Date date);

    ServerResponse<List<MailBox>> selectByMonth(Integer studentID, Date date);

    ServerResponse<List<MailBox>> selectBySituation(Integer studentID);
}
