package com.mark.springbootmall.dao;

import com.mark.springbootmall.constant.ProductCategory;
import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);
    //根據 productId去查詢這個商品的數據出來

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
