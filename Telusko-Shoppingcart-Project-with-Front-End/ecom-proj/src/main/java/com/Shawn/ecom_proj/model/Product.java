package com.Shawn.ecom_proj.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity // 建資料表
// Lombok
@Data
@AllArgsConstructor // 建 Default Constructor
@NoArgsConstructor // 建 NO ARGS Constructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description; // description
    private String brand;
    private BigDecimal price;
    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date release_date;
    private boolean product_available;
    private int stock_quantity;

    private String imageName;
    private String imageType;
    @Lob // Means Large Object
    private byte[] imageByte;

}
