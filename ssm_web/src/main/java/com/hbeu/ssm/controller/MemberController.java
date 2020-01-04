package com.hbeu.ssm.controller;

import com.hbeu.ssm.domain.Member;
import com.hbeu.ssm.domain.Orders;
import com.hbeu.ssm.service.IMemberService;
import com.hbeu.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 陈旺生
 * @create 2019-11-21 10:21
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IOrderService orderService;

    //退出
    @RequestMapping("logout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:../index/index.do";
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam(value = "name",required=false)String name, @RequestParam(value = "password",required=false)String password,@RequestParam(value = "phoneNum",required=false)String phoneNum,@RequestParam(value = "email",required=false)String email){
        Member member = new Member();
        member.setName(name);
        member.setPassword(password);
        member.setPhoneNum(phoneNum);
        member.setEmail(email);
        System.out.println("**********------------********"+member.toString());
        int i = memberService.save(member);
        if(i > 0){
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping("/buyProduct.do")
    @ResponseBody
    public String buyProduct(@RequestParam("productId") String productId,@RequestParam("memberId") String memberId) throws Exception {
        System.out.println(productId+"------"+memberId);
        if(StringUtils.isEmpty(productId) || StringUtils.isEmpty(memberId)){
            return "false";
        }
        Orders orders = orderService.findByMemberIdAndProductId(productId,memberId);
        if(orders != null){
            //该用户订单中已存在,但未支付
            int i = orderService.updateOrderByProductId(orders);
            if(i > 0){
                return "true";
            }else {
                return "false";
            }
        }else{//同商品但已经支付
             int i = orderService.addOrders(productId,memberId);
            if(i > 0){
                return "true";
            }else {
                return "true";
            }
        }
    }

    @RequestMapping("/productCart.do")
    public String productCart(){
        return "main/cart";
    }

}
