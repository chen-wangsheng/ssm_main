package com.hbeu.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.hbeu.ssm.domain.Product;
import com.hbeu.ssm.service.ICategoryService;
import com.hbeu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-07 11:41
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    //查询所有商品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        mv.addObject("productList", ps);
        mv.setViewName("main/main");
        return mv;
    }

    //分页查询所有商品
    @RequestMapping("/findAllProduct.do")
    public ModelAndView findAllProduct(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("main/main");
        return mv;
    }
    //同一类别所有商品展示
    @RequestMapping("/findAllByCategoryId.do")
    public ModelAndView findAllByCategoryId(@RequestParam("categoryId") String categoryId) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAllByCategoryId(categoryId);
        String categoryName = categoryService.findCategoryName(categoryId);
        mv.addObject("categoryName",categoryName);
        mv.addObject("products",products);
        mv.setViewName("main/more");
        return mv;
    }

/*

    //添加商品
    @RequestMapping("/save.do")
    public String save(Product product, @RequestParam("productPicFile") MultipartFile file, HttpServletRequest req) throws Exception {
        //获取服务器所在的目录
        String path = req.getSession().getServletContext().getRealPath("/");
//        System.out.println(path);
        // 图片新名字
        String productPic = UUID.randomUUID().toString();
        // 图片原来的名字
        String oldName = file.getOriginalFilename();
        // 后缀
        String sux = oldName.substring(oldName.lastIndexOf("."));
        productPic = productPic + sux;
        //获取根目录
        path = path.substring(0, path.indexOf("\\") + 1);
        //将上传文件保存到的位置+名字
        path = path + "upload\\" + productPic;
        File file1 = new File(path);
        file.transferTo(file1);//上传到D:/upload
        product.setProductPic(productPic);
        productService.save(product);
        return "redirect:findAllProduct.do";
    }
*/


}
