package com.hbeu.ssm.controller;

import com.hbeu.ssm.domain.Orders;
import com.hbeu.ssm.service.IMemberService;
import com.hbeu.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-21 8:35
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IMemberService memberService;

    @RequestMapping("/addOrDeleteNumber")
    @ResponseBody
    public String addOrDeleteNumber(@RequestParam("num") int productCount,@RequestParam("productId") String productId,@RequestParam("memberId") String memberId) throws Exception {
        Orders orders = orderService.findByMemberIdAndProductId(productId, memberId);
        int i = orderService.addOrDeleteNumber(orders,productCount);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }
    }
    //查询未支付的订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String memberId = memberService.findMemberIdByPhone(phoneNum);
        List<Orders> orders = orderService.findByMemberId(id,0);
        mv.addObject("carts",orders);
        mv.setViewName("main/cart");
        return mv;
    }

    //查询所有的订单
    @RequestMapping("/findOrdersAll.do")
    public ModelAndView findOrdersAll(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = orderService.findByMemberId(id,-1);
        mv.addObject("orders",orders);
        mv.setViewName("main/orders");
        return mv;
    }

    //支付宝沙箱支付
    @RequestMapping("/toPay.do")
    public ModelAndView toPay(@RequestParam("sum_price") String sum_price,@RequestParam("memberId") String memberId,@RequestParam("productId") String[] ids) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("sum_price",sum_price);
        //清空购物车
        for (String productId : ids) {
            orderService.updateStatus(memberId,productId);
        }
        mv.setViewName("main/toPay");
        return mv;
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("orderId")String orderId) throws Exception {
        int i = orderService.deleteById(orderId);
        if(i> 0){
            return "true";
        }else {
            return "false";
        }
    }

}
