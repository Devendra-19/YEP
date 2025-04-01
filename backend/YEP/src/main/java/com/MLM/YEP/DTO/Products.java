package com.MLM.YEP.DTO;


import com.MLM.YEP.Entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {
    private String name ;
    private String description ;
    private Double price ;
    private String url ;
    public Products(ProductEntity product){
        this.name = product.getName() ;
        this.description = product.getDescription() ;
        this.price = product.getPrice() ;
        this.url = product.getUrl() ;
    }
}
