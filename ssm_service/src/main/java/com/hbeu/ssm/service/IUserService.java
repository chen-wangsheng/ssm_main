package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Role;
import com.hbeu.ssm.domain.UserInfo;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-09 14:50
 */
public interface IUserService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);

    void addRoleToUser(String userId, String roleId);

    void userRegist(UserInfo userInfo) throws Exception;

    String findIdByUsername(String username);

    /*    UserInfo findByUsername(String username) throws Exception;*/
}
