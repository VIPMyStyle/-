package com.mryi.ssm.dao;

import com.mryi.ssm.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
  @Insert(
      "insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method}) ")
  public void save(SysLog sysLog) throws Exception;

  @Select("select * from syslog")
  List<SysLog> findAll() throws Exception;

  @Delete("delect from syslog where id=#{id}")
  void syslogDel(String[] id);
}
