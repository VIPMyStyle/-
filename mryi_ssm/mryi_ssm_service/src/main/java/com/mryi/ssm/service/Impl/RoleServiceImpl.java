package com.mryi.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.mryi.ssm.Permission;
import com.mryi.ssm.Role;
import com.mryi.ssm.dao.RoleDao;
import com.mryi.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
  @Autowired private RoleDao roleDao;

  @Override
  public List<Role> findAll(int page, int size) throws Exception {
    // pabeNum代表页码值,pageSize代表每页显示的条数
    PageHelper.startPage(page, size);
    return roleDao.findAll();
  }

  @Override
  public void save(Role role) throws Exception {
    roleDao.save(role);
  }

  @Override
  public Role findById(String roleId) throws Exception {
    return roleDao.findById(roleId);
  }

  @Override
  public List<Permission> findOtherPermissions(String roleId) throws Exception {
    return roleDao.findOtherPermissions(roleId);
  }

  @Override
  public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
    for (String permissionId : permissionIds) {
      roleDao.addPermissionToRole(roleId, permissionId);
    }
  }
}
