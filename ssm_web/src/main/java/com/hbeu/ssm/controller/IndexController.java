package com.hbeu.ssm.controller;

import com.hbeu.ssm.domain.Category;
import com.hbeu.ssm.domain.Member;
import com.hbeu.ssm.domain.Notice;
import com.hbeu.ssm.domain.Product;
import com.hbeu.ssm.service.ICategoryService;
import com.hbeu.ssm.service.IMemberService;
import com.hbeu.ssm.service.INoticeService;
import com.hbeu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-17 20:01
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IMemberService memberService;
    @Autowired
    private INoticeService noticeService;

    //首页商品展示
    @RequestMapping("/index.do")
    public ModelAndView findByCategoryId() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Category> categories = categoryService.findAll();
        List<Product> productList = productService.findByCategoryId(categories.get(0).getId());
        List<Product> productList1 = productService.findByCategoryId(categories.get(1).getId());
        List<Product> productList2 = productService.findByCategoryId(categories.get(2).getId());
        List<Product> productList3 = productService.findByCategoryId(categories.get(3).getId());
        //公告
        List<Notice> noticeList = noticeService.findNotice();
        mv.addObject("list1",productList);
        mv.addObject("list2",productList1);
        mv.addObject("list3",productList2);
        mv.addObject("list4",productList3);
        mv.addObject("notices",noticeList);
        mv.setViewName("main/main");
        return mv;
    }

    @RequestMapping("/search.do")
    public ModelAndView dimSearch(@RequestParam("name")String name){
        ModelAndView mv = new ModelAndView();
       // List<Product> products = productService.dimFindProduct(EncodingUtil.encodeStr(name));//maven启动
        List<Product> products = productService.dimFindProduct(name);//tomcat启动
        mv.addObject("products",products);
//        System.out.println(products);
        mv.setViewName("main/find");
        return mv;
    }

    //会员登录
    @RequestMapping("/login.do")
    public String login(@RequestParam(value = "name",required = false) String username, @RequestParam(value = "password",required = false) String password, HttpSession session) throws Exception {
        //通过用户名查找数据库中是否存在该用户
        Member member = memberService.findByUsername(username, password);
        if(member != null){
            session.setAttribute("member",member);
            return "redirect:index.do";
        }else {
            return "redirect:../login.jsp";
        }
    }


}
