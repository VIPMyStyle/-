package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.Permission;
import com.mryi.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
  @Autowired PermissionService permissionService;

  @RequestMapping("/findAll.do")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<Permission> permissionList = permissionService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(permissionList);
    mav.addObject("pageInfo", pageInfo);
    mav.setViewName("permission-list");
    return mav;
  }

  @RequestMapping("/save.do")
  public String save(Permission permission) throws Exception {
    permissionService.save(permission);
    return "redirect:findAll.do";
  }
}
