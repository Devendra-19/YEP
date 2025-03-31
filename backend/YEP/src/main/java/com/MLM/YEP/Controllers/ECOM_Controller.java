package com.MLM.YEP.Controllers;

import com.MLM.YEP.DTO.Products;
import com.MLM.YEP.Services.ECOM_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ECOM_Controller {
    final private ECOM_Service ecomService ;

    public ECOM_Controller(ECOM_Service ecomService){
        this.ecomService = ecomService ;
    }

    @GetMapping("/productList")
    ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(ecomService.getAll()) ;
    }
}
