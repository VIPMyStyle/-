package com.mryi.ssm.service;

import com.mryi.ssm.Orders;

import java.util.List;

public interface OrdersService {

  Orders findById(String orderId) throws Exception;

  List<Orders> findAll(int page, int size) throws Exception;

  void orderDel(String[] ids) throws Exception;
}
