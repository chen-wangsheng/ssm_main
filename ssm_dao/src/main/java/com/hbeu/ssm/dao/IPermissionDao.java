package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-10 14:05
 */
public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id} )")
     @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissionName", column = "permissionName"),
            @Result(property = "url", column = "url")
    })
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;


}
