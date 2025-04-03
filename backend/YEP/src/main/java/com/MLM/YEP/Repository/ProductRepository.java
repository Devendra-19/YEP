package com.MLM.YEP.Repository;


import com.MLM.YEP.DTO.Products;
import com.MLM.YEP.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByCategory(String category);
}
