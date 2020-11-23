package com.xingyu.controller;

import com.xingyu.domain.Product;
import com.xingyu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Product> productList= productService.findAll();
        System.out.println(productList+"product/findAll");
        mv.addObject("productList",productList);
        mv.setViewName("list");
        return mv;
    }

    /**
     * 产品添加
     * @param product
     */
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }
}
