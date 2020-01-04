package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Notice;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-23 19:35
 */
public interface INoticeService {
    List<Notice> findNotice();

    Notice findById(String noticeId);
}
