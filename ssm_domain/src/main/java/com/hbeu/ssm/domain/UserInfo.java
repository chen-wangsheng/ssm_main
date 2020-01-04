package com.hbeu.ssm.domain;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-09 15:01
 * 用户实体类
 */
public class UserInfo {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private int status; //状态 1：开启；0：未开启
    private String statusStr;
    private List<Role> roles;

    public UserInfo() {
    }

    public UserInfo(String email,String username, String password, String phoneNum, int status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public UserInfo(String id, String email,String username, String password, String phoneNum, int status, String statusStr, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
        this.statusStr = statusStr;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        //状态 1：开启；0：未开启
        if(status == 0){
            statusStr = "未开启";
        }
        if(status == 1){
            statusStr = "开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
