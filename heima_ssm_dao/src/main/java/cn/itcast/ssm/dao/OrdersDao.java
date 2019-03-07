package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrdersDao {
    /**
     * 查询所有订单
     *
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据ID查询订单
     *
     * @param id
     * @return
     */
    @Select("select * from orders where id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberID",
                    one = @One(select = "cn.itcast.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id",
                    many = @Many(select = "cn.itcast.ssm.dao.TravellerDao.findByOrdersId"))

    })
    Orders findById(String id) throws Exception;
}
