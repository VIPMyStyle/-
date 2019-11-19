package com.mryi.ssm.service;

import com.mryi.ssm.Product;

import java.util.List;

public interface ProductService {
  /**
   * 查询所有产品的方法
   *
   * @return
   * @throws Exception
   */
  public List<Product> findAll(int page, int size) throws Exception;

  /**
   * * 保存 即添加
   *
   * @param product
   */
  void save(Product product) throws Exception;

  void productDel(String[] ids) throws Exception;
}
