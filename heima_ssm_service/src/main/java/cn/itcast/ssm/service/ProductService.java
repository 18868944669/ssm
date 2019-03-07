package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有产品
     *
     * @return
     * @throws Exception
     */
    List<Product> findAll(int page, int size) throws Exception;

    /**
     * 添加产品
     *
     * @param product
     */
    void save(Product product) throws Exception;
}
