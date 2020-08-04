package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
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
public interface StudentRecodsService {

    ServerResponse updateClassRomRecods(ClassRoomRecods T);

    ServerResponse<List<ClassRoomRecods>> selectByID(Integer studentID);

    ServerResponse<List<ClassRoomRecods>> selectByDay(Integer studentID, Date date);

    ServerResponse<List<ClassRoomRecods>> selectByWeek(Integer studentID, Date date);

    ServerResponse<List<ClassRoomRecods>> selectByMonth(Integer studentID, Date date);

}
