package com.mryi.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.mryi.ssm.Permission;
import com.mryi.ssm.dao.PermissionDao;
import com.mryi.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermisssionServiceImpl implements PermissionService {
  @Autowired PermissionDao permissionDao;

  @Override
  public List<Permission> findAll(int page, int size) throws Exception {
    // pabeNum代表页码值,pageSize代表每页显示的条数
    PageHelper.startPage(page, size);
    return permissionDao.findAll();
  }

  @Override
  public void save(Permission permission) throws Exception {
    permissionDao.save(permission);
  }
}
