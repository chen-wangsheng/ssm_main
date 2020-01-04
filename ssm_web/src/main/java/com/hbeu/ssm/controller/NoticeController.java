package com.hbeu.ssm.controller;

import com.hbeu.ssm.domain.Notice;
import com.hbeu.ssm.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 陈旺生
 * @create 2019-11-23 19:34
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @RequestMapping("/findById.do")
    @ResponseBody
    public Notice findById(@RequestParam("noticeId") String noticeId){
        Notice notice = noticeService.findById(noticeId);
        return notice;
    }
}
