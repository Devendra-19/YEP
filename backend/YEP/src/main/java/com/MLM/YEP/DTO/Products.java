package com.MLM.YEP.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {
    private String name ;
    private String description ;
    private Double price ;
    private String url ;
}
