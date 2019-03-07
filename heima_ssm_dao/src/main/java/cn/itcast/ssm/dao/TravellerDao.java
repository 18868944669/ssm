package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    /**
     * 根据订单ID查询旅客
     */
    @Select("select * from traveller where id in (select travellerID from order_traveller where orderID =#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
