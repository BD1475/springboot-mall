package com.mark.springbootmall.controller;

import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//Products這個 s 很重要一定要加 這是在 RESTful 的設計原則
//商品列表一定是有很多的商品
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getProducts();

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }


    @GetMapping("/products/{productId}") //前端來請求這個 url 路徑
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        //透過 productService 的 getProductById 方法
        //去資料庫中去查詢這一筆商品的數據出來

        if (product != null) {
            //商品數據值不是 null 回傳一個 http 狀態碼 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            // 404 Not Found 表示這個商品找不到
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
//  ProductRequest 裡面有 @NotNull 的註解一定要記得加上 @Valid 的註解

//        productService 會提供一個createProduct 的方法 參數就是 productRequest
//        另外這個 createProduct 的方法他要去返回資料庫所生成的productId
        Integer productId = productService.createProduct(productRequest);

//        使用這個 productId去查詢這個商品的數據回來
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }


    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

//      檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

//      修改商品數據
//      productService會提供 updateProduct 的方法那他會有兩個參數
        productService.updateProduct(productId, productRequest);

//      使用 productId去查詢更新後的商品數據回來
        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer productId) {
        productService.deleteProductById(productId);

        //不論如何只要確定商品消失不見
        //那就表示這個刪除商品的功能是成功
        //因此我們就要回傳成功的 204 No Content 給前端
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
