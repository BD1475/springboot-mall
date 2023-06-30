package com.mark.springbootmall.controller;

import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
//  ProductRequest 裡面有 @NotNull 的註解一定要記得加上 @Valid 的註解

//        productService 會提供一個createProduct 的方法 參數就是 productRequest
//        另外這個 createProduct 的方法他要去返回資料庫所生成的productId
        Integer productId = productService.createProduct(productRequest);

//        使用這個 productId去查詢這個商品的數據回來
        Product product = productService.getProductById(productId);

        return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}
