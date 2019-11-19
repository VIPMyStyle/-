package com.mryi.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.mryi.ssm.Product;
import com.mryi.ssm.dao.ProductDao;
import com.mryi.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
  @Autowired private ProductDao productDao;

  @Override
  public List<Product> findAll(int page, int size) throws Exception {
    // pabeNum代表页码值,pageSize代表每页显示的条数
    PageHelper.startPage(page, size);
    return productDao.findAll();
  }

  @Override
  public void save(Product product) throws Exception {
    productDao.save(product);
  }

  @Override
  public void productDel(String[] ids) throws Exception {
    for (String id : ids) {
      productDao.productDel(id);
    }
  }
}
