package com.Shawn.SimpleWebApp.Controller;

import com.Shawn.SimpleWebApp.Model.Product;
import com.Shawn.SimpleWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products") // RequestMapping by Default = GetMapping
//    @GetMapping("/products")
    public List<Product> getProduct()
    {
        return service.getProduct();
    }

    @GetMapping ("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId)
    {
        return service.getProductById(prodId);
    }
    // 如果有要在 URL 路徑中加入 {prodID} ，就要加入 @PathVariable

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p)
    {
        service.addProduct(p);
//        System.out.println(p); // 記得要用 toString，這是很好看 POST 結果的方法
    }
    //從「HTTP 請求的 body 裡」接收 JSON 或 XML 等資料並轉換成 Java 物件時，要使用RequestBody

    @PutMapping("/products") // PUT == UPDATE
    public void updateProduct(@RequestBody Product p)
    {
        service.updateProduct(p);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId)
    {
        service.deleteProduct(prodId);
        System.out.println("Delete Success！");
    }
}
