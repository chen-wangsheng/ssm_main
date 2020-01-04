package com.hbeu.ssm.service.impl;

import com.hbeu.ssm.dao.IUserDao;
import com.hbeu.ssm.domain.Role;
import com.hbeu.ssm.domain.UserInfo;
import com.hbeu.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-09 14:51
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 1 ? true : false,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }*/

    //查询所有
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码加密
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRose(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for(String roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }

    public void addRoleToUser(String userId, String roleId) {
        userDao.addRoleToUser(userId,roleId);
    }

    @Override
    public void userRegist(UserInfo userInfo) throws Exception {
        userDao.save(userInfo);
    }

    @Override
    public String findIdByUsername(String username) {
        return userDao.findIdByUsername(username);
    }
/*
    @Override
    public UserInfo findByUsername(String username) throws Exception {
        return userDao.findByUsername(username);
    }*/
}
