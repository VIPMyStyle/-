package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.Role;
import com.mryi.ssm.UserInfo;
import com.mryi.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;

  @RequestMapping("/findAll.do")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<UserInfo> all = userService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(all);
    mav.addObject("pageInfo", pageInfo);
    mav.setViewName("user-list");

    return mav;
  }

  @RequestMapping("/save.do")
  @PreAuthorize("authentication.principal.username=='tomcat'")
  public String save(UserInfo userInfo) throws Exception {
    userService.save(userInfo);
    return "redirect:findAll.do";
  }

  @RequestMapping("findById.do")
  public ModelAndView findById(String id) throws Exception {
    ModelAndView mav = new ModelAndView();
    UserInfo userInfo = userService.findById(id);
    mav.addObject("user", userInfo);
    mav.setViewName("user-show");
    return mav;
  }
  // 插叙用户以及用户可以添加的角色
  @RequestMapping("/findUserByIdAndAllRole.do")
  public ModelAndView findUserByIdAndAllRole(
      @RequestParam(name = "id", required = true) String userId) throws Exception {
    ModelAndView mav = new ModelAndView();
    // 根据用户id查询用户
    UserInfo userInfo = userService.findById(userId);
    // genuine用户id查询可以添加的角色
    List<Role> otherRoles = userService.findOtherRoles(userId);
    mav.addObject("user", userInfo);
    mav.addObject("roleList", otherRoles);
    mav.setViewName("user-role-add");
    return mav;
  }
  // 给用户添加角色
  @RequestMapping("/addRoleToUser.do")
  public String addRoleToUser(
      @RequestParam(name = "userId", required = true) String userId,
      @RequestParam(name = "ids", required = true) String[] roleIds)
      throws Exception {
    userService.addRoleToUser(userId, roleIds);
    return "redirect:findAll.do";
  }
}
