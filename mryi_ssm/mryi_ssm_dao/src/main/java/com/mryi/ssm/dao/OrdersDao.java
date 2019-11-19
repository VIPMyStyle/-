package com.mryi.ssm.dao;

import com.mryi.ssm.Members;
import com.mryi.ssm.Orders;
import com.mryi.ssm.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
  @Select("select * from orders")
  @Results({
    @Result(id = true, property = "id", column = "id"),
    @Result(property = "orderNum", column = "orderNum"),
    @Result(property = "orderTime", column = "orderTime"),
    @Result(property = "orderStatus", column = "orderStatus"),
    @Result(property = "peopleCount", column = "peopleCount"),
    @Result(property = "payType", column = "payType"),
    @Result(property = "orderDesc", column = "orderDesc"),
    @Result(
        property = "product",
        column = "productId",
        javaType = Product.class,
        one = @One(select = "com.mryi.ssm.dao.ProductDao.findById")),
  })
  List<Orders> findAll() throws Exception;

  @Select("select * from orders where id=#{ordersId}")
  @Results({
    @Result(id = true, property = "id", column = "id"),
    @Result(property = "orderNum", column = "orderNum"),
    @Result(property = "orderTime", column = "orderTime"),
    @Result(property = "orderStatus", column = "orderStatus"),
    @Result(property = "peopleCount", column = "peopleCount"),
    @Result(property = "payType", column = "payType"),
    @Result(property = "orderDesc", column = "orderDesc"),
    @Result(
        property = "product",
        column = "productId",
        javaType = Product.class,
        one = @One(select = "com.mryi.ssm.dao.ProductDao.findById")),
    @Result(
        property = "member",
        column = "memberId",
        javaType = Members.class,
        one = @One(select = "com.mryi.ssm.dao.MembersDao.findById")),
    @Result(
        property = "travellers",
        column = "id",
        javaType = java.util.List.class,
        many = @Many(select = "com.mryi.ssm.dao.TravellerDao.findByOrdersId"))
  })
  public Orders findById(String orderId) throws Exception;

  // @Delete("delete from orders where id=#{id}")
  @Delete("delete from orders where id=#{id}")
  @Results({
    @Result(id = true, property = "id", column = "id"),
    @Result(property = "orderNum", column = "orderNum"),
    @Result(property = "orderTime", column = "orderTime"),
    @Result(property = "orderStatus", column = "orderStatus"),
    @Result(property = "peopleCount", column = "peopleCount"),
    @Result(property = "payType", column = "payType"),
    @Result(property = "orderDesc", column = "orderDesc"),
    @Result(
        property = "product",
        column = "productId",
        javaType = Product.class,
        one = @One(select = "com.mryi.ssm.dao.ProductDao.findById")),
    @Result(
        property = "member",
        column = "memberId",
        javaType = Members.class,
        one = @One(select = "com.mryi.ssm.dao.MembersDao.findById")),
    @Result(
        property = "travellers",
        column = "id",
        javaType = java.util.List.class,
        many = @Many(select = "com.mryi.ssm.dao.TravellerDao.findByOrdersId"))
  })
  void orderDel(String[] id) throws Exception;
}
