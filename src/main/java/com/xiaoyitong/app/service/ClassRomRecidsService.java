package com.xiaoyitong.app.service;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
import com.xiaoyitong.app.pojo.StudentLeave;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Method '$
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
@Service
public interface ClassRomRecidsService {

    ServerResponse updateClassRomRecods(ClassRoomRecods t);

    ServerResponse<List<ClassRoomRecods>> selectById(Integer student_id);

    ServerResponse<List<ClassRoomRecods>> selectByDay(Integer student_id, Date date);

    ServerResponse<List<ClassRoomRecods>> selectByWeek(Integer student_id, Date date);

    ServerResponse<List<ClassRoomRecods>> selectByMonth(Integer student_id, Date date);

}
