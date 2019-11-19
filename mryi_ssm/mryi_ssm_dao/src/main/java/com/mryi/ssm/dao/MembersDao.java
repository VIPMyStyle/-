package com.mryi.ssm.dao;

import com.mryi.ssm.Members;
import org.apache.ibatis.annotations.Select;

public interface MembersDao {
  @Select("select * from member where id=#{id}")
  public Members findById(String id) throws Exception;
}
