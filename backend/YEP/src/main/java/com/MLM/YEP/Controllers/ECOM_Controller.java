package com.MLM.YEP.Controllers;

import com.MLM.YEP.DTO.Products;
import com.MLM.YEP.Services.ECOM_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ECOM_Controller {
    final private ECOM_Service ecomService ;

    public ECOM_Controller(ECOM_Service ecomService){
        this.ecomService = ecomService ;
    }

    @GetMapping("/productList")
    ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(ecomService.getAll()) ;
    }

    @PostMapping("/addProduct")
    ResponseEntity<Products> addProduct(@RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("price") Double price,
                                        @RequestParam("image")MultipartFile image) throws IOException {
        return ResponseEntity.ok(ecomService.addProduct(name, description, price, image)) ;
    }


    @GetMapping("/{category}")
    ResponseEntity<List<Products>> getProductByCategory(@PathVariable String category){
        return ResponseEntity.ok(ecomService.getProductByCategory(category)) ;
    }
}
