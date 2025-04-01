package com.MLM.YEP.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description ;
    private Double price ;
    private String url ;
    private Boolean isDeleted ;
    private Date createdAt ;
    private Date updatedAt ;
}


//