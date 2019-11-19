package com.mryi.ssm.service;

import com.mryi.ssm.Permission;

import java.util.List;

public interface PermissionService {
  public List<Permission> findAll(int page, int size) throws Exception;

  void save(Permission permission) throws Exception;
}
