package com.xiaoyitong.app.dao;

import com.xiaoyitong.app.pojo.MailBox;
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
public interface MailBoxMapper {

    @Update("update mail_box set situation=1 where article_id=#{article}")
    int updateStiuation(Integer article);

    @Select("select * from mail_box where receiver_id=#{student_id}")
    List<MailBox> selectById(Integer student_id);

    @Select("select * from mail_box where " +
            "DATE_SUB(#{date}, INTERVAL 1 DAY) <= date(sending_time) " +
            " and receiver_id=#{studentID}")
    List<MailBox> selectByDay(Integer studentID, Date date);

    @Select("select * from mail_box where " +
            "DATE_SUB(#{date}, INTERVAL 7 DAY) <= date(sending_time) " +
            " and receiver_id=#{studentID}")
    List<MailBox> selectByWeek(Integer studentID, Date date);

    @Select("select * from mail_box where " +
            "DATE_SUB(#{date}, INTERVAL 7 DAY) <= date(sending_time) " +
            " and receiver_id=#{studentID}")
    List<MailBox> selectByMonth(Integer studentID, Date date);

    @Select("select * from mail_box where " +
            "receiver_id=#{studentID} " +
            " and situation=0")
    List<MailBox> selectBySituation(Integer studentID);
}
