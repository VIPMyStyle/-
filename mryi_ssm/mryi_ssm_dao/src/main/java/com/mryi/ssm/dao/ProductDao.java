package com.mryi.ssm.dao;

import com.mryi.ssm.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
  /**
   * 查询所有的方法
   *
   * @return
   * @throws Exception
   */
  @Select("select * from product")
  public List<Product> findAll() throws Exception;

  /**
   * 保存 即添加的方法
   *
   * @param product
   */
  @Insert(
      "insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
  void save(Product product);

  @Select("select * from product where id=#{id}")
  public Product findById(String id) throws Exception;

  @Delete("delete from product where id=#{id}")
  void productDel(String id) throws Exception;
}
