package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.Orders;
import com.mryi.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
  @Autowired OrdersService ordersService;
  //// 查询所有  为分页的操作
  //  @RequestMapping("/findAll.do")
  //  public ModelAndView findAll() throws Exception {
  //    ModelAndView mav = new ModelAndView();
  //    List<Orders> ordersList = ordersService.findAll();
  //    mav.addObject("ordersList", ordersList);
  //    mav.setViewName("orders-list");
  //
  //    return mav;
  //  }
  @Secured("ROLE_ADMIN")
  @RequestMapping("/findAll.do")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<Orders> ordersList = ordersService.findAll(page, size);
    // pageinfo就是一个分页的bean
    PageInfo pageInfo = new PageInfo(ordersList);
    mav.addObject("pageInfo", pageInfo);
    mav.setViewName("orders-page-list");

    return mav;
  }

  @RequestMapping("/findById")
  public ModelAndView findById(@RequestParam(name = "id", required = true) String orderId)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    Orders orders = ordersService.findById(orderId);
    mav.addObject("orders", orders);
    mav.setViewName("orders-show");
    return mav;
  }

  @RequestMapping("/orderDel.do")
  public String productDel(@RequestParam(name = "id", required = true) String[] ids)
      throws Exception {
    ordersService.orderDel(ids);
    return "redirect:findAll.do";
  }
}
