package com.xiaoyitong.app.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class StudentException {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.student_id
     *
     * @mbggenerated
     */
    private Integer student_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.major
     *
     * @mbggenerated
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.grade
     *
     * @mbggenerated
     */
    private Integer grade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.phone
     *
     * @mbggenerated
     */
    private Integer phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.situation
     *
     * @mbggenerated
     */
    private String situation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_exception.remarks
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_exception.student_id
     *
     * @return the value of student_exception.student_id
     *
     * @mbggenerated
     */
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
