package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.StudentLeave;
import com.xiaoyitong.app.pojo.StudentStatues;
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
public interface StudentLeaveService {

    ServerResponse update(StudentLeave T);

    ServerResponse<List<StudentLeave>> selectByID(Integer studentID);

    ServerResponse<List<StudentLeave>> selectByDay(Integer studentID, Date date);

    ServerResponse<List<StudentLeave>> selectByWeek(Integer studentID, Date date);

    ServerResponse<List<StudentLeave>> selectByMonth(Integer studentID, Date date);
}
