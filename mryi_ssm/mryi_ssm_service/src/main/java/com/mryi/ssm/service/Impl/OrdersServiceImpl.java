package com.mryi.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.mryi.ssm.Orders;
import com.mryi.ssm.dao.OrdersDao;
import com.mryi.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
  @Autowired private OrdersDao ordersDao;

  @Override
  public Orders findById(String orderId) throws Exception {
    return ordersDao.findById(orderId);
  }

  @Override
  public List<Orders> findAll(int page, int size) throws Exception {
    // pabeNum代表页码值,pageSize代表每页显示的条数
    PageHelper.startPage(page, size);
    return ordersDao.findAll();
  }

  @Override
  public void orderDel(String[] ids) throws Exception {
    ordersDao.orderDel(ids);
  }
}
