package com.mryi.ssm.service;

import com.mryi.ssm.Role;
import com.mryi.ssm.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
  /**
   * 查找所有用户
   *
   * @return
   * @throws Exception
   */
  public List<UserInfo> findAll(int page, int size) throws Exception;

  void save(UserInfo userInfo) throws Exception;

  UserInfo findById(String id) throws Exception;

  List<Role> findOtherRoles(String userId) throws Exception;

  void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
