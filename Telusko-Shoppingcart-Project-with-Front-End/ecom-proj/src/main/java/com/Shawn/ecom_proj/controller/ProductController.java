package com.Shawn.ecom_proj.controller;

import com.Shawn.ecom_proj.model.Product;
import com.Shawn.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin // 因為前後端連接的Port不一樣 所以需要更改Port
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getProduct()
    {
        return new ResponseEntity<>(service.getProduct(), HttpStatus.OK);
        // OK 會回傳 status 200
    }

    @RequestMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id)
    {
        Product prod = service.getProductById(id);

        if(prod != null)
            return new ResponseEntity<>(prod, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile) // 因為是 Image 所以用 RequestPart
    // <?> 是 Java 的泛型語法，代表「不確定的類型」，意思是這個 ResponseEntity 可以回傳任意類型的資料。
    {
        try
        {
            Product prod = service.addProduct(product, imageFile);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id)
    {
        Product product = service.getProductById(id);
        byte[] imageFile = product.getImageByte();

        return ResponseEntity.ok()
            .contentType(MediaType.valueOf(product.getImageType()))
            .body(imageFile);
    }

    @PutMapping(value = "product/{id}") // Put 是 Update 的意思
    public ResponseEntity<String> updateProduct(@RequestPart Product product,
                                                @RequestPart MultipartFile imageFile)
    {
        Product prod = null;
        try {
            prod = service.updateProduct(product, imageFile);
            System.out.println("1");
        } catch (IOException e) {
            System.out.println("Here");
            throw new RuntimeException(e);
        }
        // 他不給我直接寫 Product prod = service.updateProduct(id, product, imageFile);

        if(prod != null) {
            System.out.println("2");
            return new ResponseEntity<>("Update Seccess", HttpStatus.OK);
        }
        else{
            System.out.println("There");
            return new ResponseEntity<>("Update Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String>delete(@PathVariable int id)
    {
        Product product = service.getProductById(id); // 因為要 回傳 String 所以必須要測試是否 get 的到
        if(product != null) {
            service.deleteProduct(product);
            System.out.println("Here");
            return new ResponseEntity<>("Delete Seccess", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Delete Failed", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(String keyword)
    {
        System.out.println("searching with " + keyword); // 這行很方便可以Debug
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



}
