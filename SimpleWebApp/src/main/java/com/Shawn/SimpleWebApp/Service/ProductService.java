package com.Shawn.SimpleWebApp.Service;

import com.Shawn.SimpleWebApp.Model.Product;
import com.Shawn.SimpleWebApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired // 連接 Component
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"IPhone",50000),
//            new Product(102,"Canon",70000),
//            new Product(103,"Shure",10000)));

    public List<Product> getProduct()
    {
//        return products;
        return repo.findAll();
    }

    public Product getProductById(int prodId)
    {
//        return products.get(prodId); // 這裡因為是用 <Product> 當 Index 所以不能用 int 當 Index
//        return products.stream()
//                .filter(p -> p.getProduct_id() == prodId)
//                .findFirst().orElse(new Product(100,"No Item", 0));
        return repo.findById(prodId).orElse(new Product(100,"No Item", 0));
    }

    public void addProduct(Product p)
    {
//        products.add(p); // Array.asList 不能用 add()
        repo.save(p);
    }

    public void updateProduct(Product p)
    {
//        for(int i=0 ; i<products.size() ; ++i)
//        {
//            // 這裡 get(i) 會取得第幾號的Product (因為ArrayList可以，但Array.asList不行)
//            // 之後再呼叫 Product class 中的 getProduct_id() 來獲取 id
//            if(products.get(i).getProduct_id() == p.getProduct_id())
//            {
//                products.set(i,p); // set( 第幾個元素, 換的item )
//            }
//        }
        repo.save(p);
        // save = if it exists, then do nothing, if not, then create = update
    }

    public void deleteProduct(int prodId)
    {
//        for(int i=0 ; i<products.size() ; ++i)
//        {
//            if(products.get(i).getProduct_id() == prodId)
//            {
//                products.remove(i); // set( 第幾個元素, 換的item )
//            }
//        }
        repo.deleteById(prodId);
    }
}
