package com.xiaoyitong.app.pojo;

import lombok.Data;

@Data
public class TeacherLogin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_login.teacher_id
     *
     * @mbggenerated
     */
    private Integer teacher_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_login.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_login.phone
     *
     * @mbggenerated
     */
    private Integer phone;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}