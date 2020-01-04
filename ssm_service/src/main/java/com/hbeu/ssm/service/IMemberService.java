package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Member;

/**
 * @author 陈旺生
 * @create 2019-11-21 10:25
 */
public interface IMemberService {
    Member findByUsername(String username,String password) throws Exception;

    int save(Member member);

    String findMemberIdByPhone(String phoneNum);
}
