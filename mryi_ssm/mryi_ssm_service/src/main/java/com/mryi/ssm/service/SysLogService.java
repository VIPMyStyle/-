package com.mryi.ssm.service;

import com.mryi.ssm.SysLog;

import java.util.List;

public interface SysLogService {
  public void save(SysLog sysLog) throws Exception;

  List<SysLog> findAll(int page, int size) throws Exception;

  void syslogDel(String[] ids) throws Exception;
}
