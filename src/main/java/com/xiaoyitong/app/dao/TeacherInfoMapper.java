package com.xiaoyitong.app.dao;

import com.xiaoyitong.app.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TeacherInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer teacherId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    int insert(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    int insertSelective(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    TeacherInfo selectByPrimaryKey(Integer teacherId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TeacherInfo record);
}
