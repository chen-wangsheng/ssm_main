package com.hbeu.ssm.service.impl;

import com.hbeu.ssm.dao.INoticeDao;
import com.hbeu.ssm.domain.Notice;
import com.hbeu.ssm.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-23 19:35
 */
@Service
@Transactional
public class NoticeService implements INoticeService {

    @Autowired
    private INoticeDao noticeDao;

    @Override
    public List<Notice> findNotice() {
        return noticeDao.findNotice();
    }

    @Override
    public Notice findById(String noticeId) {
        return noticeDao.findById(noticeId);
    }
}
