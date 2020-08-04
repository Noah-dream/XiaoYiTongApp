package com.xiaoyitong.app.pojo;

import lombok.Data;

import java.util.Date;
@Data

public class StudentLeave {

    private Integer student_id;

    private Integer statues;

    private String name;

    private Integer temperature;

    private Date date;

    private String importance;

    private String reason;

    private Integer approve_id;

    private Date approve_date;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getStatues() {
        return statues;
    }

    public void setStatues(Integer statues) {
        this.statues = statues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getApprove_id() {
        return approve_id;
    }

    public void setApprove_id(Integer approve_id) {
        this.approve_id = approve_id;
    }

    public Date getApprove_date() {
        return approve_date;
    }

    public void setApprove_date(Date approve_date) {
        this.approve_date = approve_date;
    }
}
