package com.xiaoyitong.app.dao;

import com.xiaoyitong.app.pojo.ClassRoomRecods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface ClassRomRecodsMapper {

    @Insert("insert into classrom_recods (building,classroom,date,student_id,name,leave_date) values (#{building}，#{classroom}，#{date}，#{studentID}，#{leaveDate})")
    int updateClassRomRecods(ClassRoomRecods T);

    @Select("select * from classroom_recods where student_id=#{student_id}")
    List<ClassRoomRecods> selectById(Integer student_id);

    @Select("select * from classroom_recods where " +
            "DATE_SUB(#{date}, INTERVAL 1 DAY) <= date(date) " +
            " student_id=#{studentID}")
    List<ClassRoomRecods> selectByDay(Integer studentID, Date date);

    @Select("select * from classroom_recods where " +
            "DATE_SUB(#{date}, INTERVAL 7 DAY) <= date(date) " +
            " and student_id=#{studentID}")
    List<ClassRoomRecods> selectByWeek(Integer studentID, Date date);

    @Select("select * from classroom_recods where " +
            "DATE_SUB(#{date}, INTERVAL 1 MONTH) <= date(date) " +
            " and student_id=#{studentID}")
    List<ClassRoomRecods> selectByMonth(Integer studentID, Date date);

}
