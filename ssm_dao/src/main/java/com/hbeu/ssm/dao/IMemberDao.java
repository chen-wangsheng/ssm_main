package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-21 10:27
 */
public interface IMemberDao {

    @Select("select * from member where name=#{username,jdbcType=NULL}")
    List<Member> findByUsername(String username);

    @Insert("insert into member(name,phoneNum,email,password) values(#{member.name,jdbcType=NULL},#{member.phoneNum,jdbcType=NULL},#{member.email,jdbcType=NULL},#{member.password,jdbcType=NULL})")
    int save(@Param("member") Member member);

    @Select("select * from member where phoneNum=#{phoneNum}")
    String findMemberIdByPhone(String phoneNum);

    @Select("select * from member where id=#{memberId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "email", property = "email")
    })
    Member findById(String memberId) throws Exception;
}
