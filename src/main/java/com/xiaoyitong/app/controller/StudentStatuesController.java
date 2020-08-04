package com.xiaoyitong.app.controller;

import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.StudentStatues;
import com.xiaoyitong.app.service.StudentStatuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class StudentStatuesController {

    @Autowired
    StudentStatuesService studentStatuesService;
    
    @RequestMapping(value = "updateStudentStatues", method = RequestMethod.POST)
    public ServerResponse updateStudentStatues(@RequestParam("studentStatues") StudentStatues studentStatues){
        return studentStatuesService.updateStudentStatues(studentStatues);
    }

}
