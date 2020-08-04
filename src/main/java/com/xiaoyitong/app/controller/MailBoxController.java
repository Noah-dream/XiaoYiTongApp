package com.xiaoyitong.app.controller;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import com.xiaoyitong.app.common.ServerResponse;
import com.xiaoyitong.app.pojo.MailBox;
import com.xiaoyitong.app.service.MailBoxService;
import com.xiaoyitong.app.utils.DateFormatUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description 这里是个人信箱，完成查看个人信箱的功能
 * @Return $
 * @Exception $
 * @Date $ $
 */
@RestController
@RequestMapping("/app/")
public class MailBoxController {

    @Autowired
    MailBoxService mailBoxService;

//    @RequestMapping(value = "updateSituation", method = RequestMethod.POST)
//    public ServerResponse updateSitudation(@RequestParam("article_id")Integer id){
//        return mailBoxService.updateSituation(id);
//    }

    @GetMapping("getMailById")
    public ServerResponse<List<MailBox>> getMailById(@RequestParam("student_id") Integer id){
        return mailBoxService.selectByID(id);
    }

    @GetMapping("getMailByDay")
    public ServerResponse<List<MailBox>> getMailByDay(@RequestParam("student_id") Integer id, @RequestParam("date")String date) throws ParseException{
        return mailBoxService.selectByDay(id,DateFormatUtil.format(date));
    }

    @GetMapping("getMailByMonth")
    public ServerResponse<List<MailBox>> getMailByMonth(@RequestParam("student_id") Integer id, @RequestParam("date")String date) throws ParseException {
        return mailBoxService.selectByMonth(id,DateFormatUtil.format(date));
    }

    @GetMapping("getMailByWeek")
    public ServerResponse<List<MailBox>> getMailByWeek(@RequestParam("student_id") Integer id, @RequestParam("date")String date) throws ParseException{
        return mailBoxService.selectByWeek(id,DateFormatUtil.format(date));
    }

    @GetMapping("getMailBySituation")
    public ServerResponse<List<MailBox>> getMailBySituation(@RequestParam("student_id") Integer id){
        return mailBoxService.selectBySituation(id);
    }
}
