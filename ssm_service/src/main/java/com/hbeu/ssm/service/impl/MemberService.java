package com.hbeu.ssm.service.impl;

import com.hbeu.ssm.dao.IMemberDao;
import com.hbeu.ssm.domain.Member;
import com.hbeu.ssm.service.IMemberService;
import com.hbeu.ssm.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-21 10:25
 */
@Service
@Transactional
public class MemberService implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    @Override
    public Member findByUsername(String username,String password) throws Exception {
        List<Member> members = memberDao.findByUsername(username);
        Member member = null;
        if(!CollectionUtils.isEmpty(members)){
            //增强for循环：快捷键iter
            for (Member e : members) {
                if(PasswordUtil.verify(password,e.getPassword())){
                    member = e;
                    break;
                }
            }
        }
        return  member;
    }

    @Override
    public int save(Member member) {
        //密码加盐
        String pwd = PasswordUtil.generate(member.getPassword());
        member.setPassword(pwd);
        return memberDao.save(member);
    }

    @Override
    public String findMemberIdByPhone(String phoneNum) {
        return memberDao.findMemberIdByPhone(phoneNum);
    }

}
