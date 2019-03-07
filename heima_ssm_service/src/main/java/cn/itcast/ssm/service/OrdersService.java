package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 分页查询所有订单
     *
     * @return
     */
    List<Orders> findAll(int page, int size) throws Exception;

    /**
     * 根据ID查询订单
     *
     * @param ordersId
     * @return
     */
    Orders findById(String ordersId) throws Exception;
}
