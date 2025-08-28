package com.Shawn.ecom_proj.repo;

import com.Shawn.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    // 想要 Extend the "Search Function" -> 寫 JPQL (Java Persistence Query Language)
    // (類似 SQL 但
    // 1.Table name -> Class name
    // 2.Class name -> Field name(就是那些Product變數))

    @Query("SELECT p from Product p Where " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")

    // 選取整個表格，查看每個 Column name (Field name) 哪些有 keyword 的
    // p = class, name, id, date ... 都是 p 的變數
    // LIKE = match
    // LOWER 就是 變小寫 怕會有大小寫問題
    // '%' = 匹配任意數量的任意字元
    // + 是在jave中 多個字串 接起來的功能，至於為什麼不用 CONCAT (因為那是JPQL語法)
    // :keyword 指 keyword是要傳入的變數

    List<Product> searchProducts(String keyword);

}