package com.Shawn.SimpleWebApp.Repository;

import com.Shawn.SimpleWebApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
// Because we define Interface we let the Spring data JPA help us create the class of it
// we have to extends JpaRepository < ClassName, Primary Key type > 