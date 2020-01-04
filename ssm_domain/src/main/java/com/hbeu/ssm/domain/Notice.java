package com.hbeu.ssm.domain;

import com.hbeu.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 陈旺生
 * @create 2019-11-19 21:58
 */
public class Notice {
    private String id;
    private String noticeNum;
    private String noticeTitle;
    private String noticeContent;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createTime; // 发布时间
    private String createTimeStr;
    private Integer noticeStatus; // 状态 0 关闭 1 开启
    private String noticeStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(String noticeNum) {
        this.noticeNum = noticeNum;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if (createTime != null) {
            createTimeStr = DateUtils.date2String(createTime, "yyyy-MM-dd HH:mm:ss");
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeStatusStr() {
        // 状态 0 关闭 1 开启
        if (noticeStatus != null) {
            if(noticeStatus==0)
                noticeStatusStr="关闭";
            if(noticeStatus==1)
                noticeStatusStr="开启";
        }
        return noticeStatusStr;
    }

    public void setNoticeStatusStr(String noticeStatusStr) {
        this.noticeStatusStr = noticeStatusStr;
    }
}
