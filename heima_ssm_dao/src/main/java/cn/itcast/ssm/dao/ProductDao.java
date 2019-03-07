package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有产品
     *
     * @return
     * @throws Exception
     */

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 添加产品
     *
     * @param product
     */

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询产品
     *
     * @param id
     * @return
     * @throws Exception
     */

    @Select("select * from product where id = #{id}")
    Product findById(String id) throws Exception;
}
