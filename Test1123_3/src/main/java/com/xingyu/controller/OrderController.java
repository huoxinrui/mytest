package com.xingyu.controller;

import com.github.pagehelper.PageInfo;
import com.xingyu.domain.Orders;
import com.xingyu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv=new ModelAndView();
        List<Orders> orders= orderService.findAll(page, size);

        PageInfo pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orderList");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id",required = true) int id){
        ModelAndView mv=new ModelAndView();
        Orders order= orderService.findById(id);

        mv.addObject("ordersFindById",order);
        mv.setViewName("orderDetail");
        return mv;
    }

}
