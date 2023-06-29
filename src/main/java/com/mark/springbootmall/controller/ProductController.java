package com.mark.springbootmall.controller;

import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}") //前端來請求這個 url 路徑
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        //透過 productService 的 getProductById 方法
        //去資料庫中去查詢這一筆商品的數據出來

        if (product != null){
            //商品數據值不是 null 回傳一個 http 狀態碼 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            // 404 Not Found 表示這個商品找不到
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
