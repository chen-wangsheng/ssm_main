package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-23 19:36
 */
public interface INoticeDao {

    @Select("select * from notice where noticeStatus=1 and rownum<6")
    List<Notice> findNotice();

    @Select("select * from notice where id=#{noticeId}")
    Notice findById(String noticeId);
}
