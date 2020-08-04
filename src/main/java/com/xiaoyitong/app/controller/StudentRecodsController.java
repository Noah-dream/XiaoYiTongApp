package com.xiaoyitong.app.controller;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.ClassRoomRecods;
import com.xiaoyitong.app.service.StudentRecodsService;
import com.xiaoyitong.app.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
@RestController
@RequestMapping("/app/")
public class StudentRecodsController {

    @Autowired
    StudentRecodsService studentRecodsService;

    @RequestMapping(value = "updateStudentRecods", method = RequestMethod.POST)
    public ServerResponse updateStudentRecods(@RequestParam("classRoomRecods") ClassRoomRecods classRoomRecods){
        return studentRecodsService.updateClassRomRecods(classRoomRecods);
    }
    @GetMapping("getRecodsById")
    public ServerResponse<List<ClassRoomRecods>> getRecodsById(@RequestParam("student_id") Integer student_id){
        return studentRecodsService.selectByID(student_id);
    }
    @GetMapping("getRecodsByDay")
    public ServerResponse<List<ClassRoomRecods>> getRecodsByDay(@RequestParam("student_id") Integer student_id,@RequestParam("date")String date) throws ParseException {
        return studentRecodsService.selectByDay(student_id,DateFormatUtil.format(date));
    }
    @GetMapping("getRecodsByWeek")
    public ServerResponse<List<ClassRoomRecods>> getRecodsByWeek(@RequestParam("student_id") Integer student_id, @RequestParam("date")String date) throws ParseException {
        return studentRecodsService.selectByWeek(student_id,DateFormatUtil.format(date));
    }
    @GetMapping("getRecodsByMonth")
    public ServerResponse<List<ClassRoomRecods>> getRecodsByMonth(@RequestParam("student_id") Integer student_id, @RequestParam("date")String date) throws ParseException {
        return studentRecodsService.selectByMonth(student_id,DateFormatUtil.format(date));
    }
}
