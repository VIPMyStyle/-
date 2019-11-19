package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.Permission;
import com.mryi.ssm.Role;
import com.mryi.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
  @Autowired private RoleService roleService;

  @RequestMapping("/findAll.do")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<Role> roleList = roleService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(roleList);
    mav.addObject("pageInfo", pageInfo);
    mav.setViewName("role-list");
    return mav;
  }

  @RequestMapping("save.do")
  public String save(Role role) throws Exception {
    roleService.save(role);
    return "redirect:findAll.do";
  }
  // 根据roleId查询role,并查出可以添加的权限
  // name = "id", required = true页面传过来的值的名称为id
  @RequestMapping("/findRoleByIdAndAllPermission.do")
  public ModelAndView findRoleByIdAndAllPermission(
      @RequestParam(name = "id", required = true) String roleId) throws Exception {
    ModelAndView mav = new ModelAndView();
    // 根据roleId查询role
    Role role = roleService.findById(roleId);
    // 根据roleId查询可以添加的权限
    List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
    mav.addObject("role", role);
    mav.addObject("permissionList", otherPermissions);
    mav.setViewName("role-permission-add");
    return mav;
  }
  // 给角色添加权限的方法
  @RequestMapping("/addPermissionToRole.do")
  public String addPermissionToRole(
      @RequestParam(name = "roleId", required = true) String roleId,
      @RequestParam(name = "ids", required = true) String[] permissionIds)
      throws Exception {
    roleService.addPermissionToRole(roleId, permissionIds);
    return "redirect:findAll.do";
  }
}
