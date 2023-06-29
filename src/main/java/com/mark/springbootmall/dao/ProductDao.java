package com.mark.springbootmall.dao;

import com.mark.springbootmall.model.Product;
import org.springframework.stereotype.Component;


public interface ProductDao {

    Product getProductById(Integer productId);
    //根據 productId去查詢這個商品的數據出來
}