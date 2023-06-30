package com.mark.springbootmall.service.impl;

import com.mark.springbootmall.dao.ProductDao;
import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    // Service 層 直接去 call ProductDao的 getProductById 方法
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
