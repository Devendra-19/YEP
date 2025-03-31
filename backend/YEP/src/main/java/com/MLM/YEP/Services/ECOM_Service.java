package com.MLM.YEP.Services;
import com.MLM.YEP.DTO.Products;
import com.MLM.YEP.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ECOM_Service {
    final private ProductRepository productRepository ;

    ECOM_Service(ProductRepository productRepository){
        this.productRepository = productRepository ;
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
}
