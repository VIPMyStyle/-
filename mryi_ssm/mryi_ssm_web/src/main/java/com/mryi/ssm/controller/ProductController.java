package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.Product;
import com.mryi.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired private ProductService productService;

  @RequestMapping("/findAll.do")
  // @RolesAllowed("ADMIN")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<Product> ps = productService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(ps);
    mav.setViewName("product-list");
    mav.addObject("pageInfo", pageInfo);
    return mav;
  }
  //  @RequestMapping("/findAll.do")
  //  public ModelAndView findAll(
  //      @RequestParam(name = "page", required = true, defaultValue = "1") int page,
  //      @RequestParam(name = "size", required = true, defaultValue = "3") int size)
  //      throws Exception {
  //    ModelAndView mav = new ModelAndView();
  //    List<Product> ps = productService.findAll(page, size);
  //    PageInfo productList = new PageInfo(ps);
  //    mav.setViewName("product-list");
  //    mav.addObject("productList", productList);
  //    return mav;
  //  }

  @RequestMapping("/save.do")
  public String save(Product product) throws Exception {
    productService.save(product);
    return "redirect:findAll.do";
  }

  @RequestMapping("/productDel.do")
  public String productDel(@RequestParam(name = "id", required = true) String[] ids)
      throws Exception {
    productService.productDel(ids);
    return "redirect:findAll.do";
  }
}
