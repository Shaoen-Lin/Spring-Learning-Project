package com.Shawn.ecom_proj.service;

import com.Shawn.ecom_proj.model.Product;
import com.Shawn.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProduct() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);

        //return repo.findById(prodId); 會回傳 Optional 物件，也就是沒有就不會回傳了。
        // 所以要加上 orElse
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageByte(imageFile.getBytes());

        return repo.save(product); // save 會 return 一個實體所以 要用 save 必須改成 Product 不能 void
    }

    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageByte(imageFile.getBytes());

        return repo.save(product);
    }

    public void deleteProduct(Product product) {
        repo.delete(product);
    }

    public List<Product> searchProducts(String keyword)
    {
        return repo.searchProducts(keyword);
    }
}
