package com.xiaoyitong.app.dao;

import com.xiaoyitong.app.pojo.StudentLeave;
import com.xiaoyitong.app.pojo.StudentStatues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface StudentLeaveMapper {
    /**
     * This method was generated by Noah
     *
     * @mbggenerated
     */
    @Select("select * from student_leave where student_id=#{student_id}")
    List<StudentLeave> selectById(Integer student_id);

    @Select("select * from student_leave where " +
            "DATE_SUB(#{date}, INTERVAL 1 DAY) <= date(date) " +
            " and student_id=#{studentID}")
    List<StudentLeave> selectByDay(Integer studentID,Date date);

    @Select("select * from student_leave where " +
            "DATE_SUB(#{date}, INTERVAL 7 DAY) <= date(date) " +
            " and student_id=#{studentID}")
    List<StudentLeave> selectByWeek(Integer studentID, Date date);

    @Select("select * from student_leave where " +
            "DATE_SUB(#{date}, INTERVAL 1 MONTH) <= date(date) " +
            " and student_id=#{studentID}")
    List<StudentLeave> selectByMonth(Integer studentID, Date date);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    @Update("UPDATE student_leave SET approve_id = #{teacher_id},statues = #{statues} , approve_date= #{approve_date} WHERE student_id = #{student_id}")
    public void dealaApprove(Integer teacher_id, Integer student_id, Integer statues, Date approve_date);
    int deleteByPrimaryKey(Integer studentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    int insert(StudentLeave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    int insertSelective(StudentLeave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    StudentLeave selectByPrimaryKey(Integer studentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StudentLeave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_leave
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StudentLeave record);
}