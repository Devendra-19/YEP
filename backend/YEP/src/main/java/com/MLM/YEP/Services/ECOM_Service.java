package com.MLM.YEP.Services;
import com.MLM.YEP.DTO.Products;
import com.MLM.YEP.Entities.ProductEntity;
import com.MLM.YEP.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ECOM_Service {
    final private ProductRepository productRepository ;
    final private ImageProcessingService imageProcessingService ;

    ECOM_Service(ProductRepository productRepository,ImageProcessingService imageProcessingService){
        this.productRepository = productRepository ;
        this.imageProcessingService = imageProcessingService ;
    }
    public List<Products> getAll() {
        return productRepository.
                findAll().
                stream().map(
                        product -> new Products(
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getUrl())
                ).
                collect(Collectors.toList());
    }

    public Products addProduct(String name, String description, Double price, MultipartFile image)
            throws IOException {
        ProductEntity newProduct = new ProductEntity() ;
        String url = imageProcessingService.generateURL(image, name) ;
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setUrl(url);
        newProduct.setPrice(price);
        productRepository.save(newProduct);
        return new Products(newProduct) ;
    }
}
