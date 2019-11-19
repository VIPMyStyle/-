package com.mryi.ssm.service;

import com.mryi.ssm.Permission;
import com.mryi.ssm.Role;

import java.util.List;

public interface RoleService {
  public List<Role> findAll(int page, int size) throws Exception;

  void save(Role role) throws Exception;

  Role findById(String roleId) throws Exception;

  List<Permission> findOtherPermissions(String roleId) throws Exception;

  void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
