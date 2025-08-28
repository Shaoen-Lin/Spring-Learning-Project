package com.Shawn.SimpleWebApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Data // 自動為每個變數產生 Getter()、Setter()、ToString()...
//@AllArgsConstructor // 他會自動生成每個變數的Constructor
@Component
@Entity
//讓這個 class 對應到資料庫中的一個資料表（table）
public class Product {
    @Id // 說明 這個資料表的 product_id
    private Integer product_id;
    private String product_name;
    private Integer price;

    public Product() {
    }

    public Product(int product_id, String product_name, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
