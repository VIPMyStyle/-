package com.mryi.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.mryi.ssm.SysLog;
import com.mryi.ssm.dao.SysLogDao;
import com.mryi.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
  @Autowired SysLogDao sysLogDao;

  @Override
  public void save(SysLog sysLog) throws Exception {
    sysLogDao.save(sysLog);
  }

  @Override
  public List<SysLog> findAll(int page, int size) throws Exception {
    // pabeNum代表页码值,pageSize代表每页显示的条数
    PageHelper.startPage(page, size);
    return sysLogDao.findAll();
  }

  @Override
  public void syslogDel(String[] ids) throws Exception {
    sysLogDao.syslogDel(ids);
  }
}
