package com.example.productcrud2.util;

import com.example.productcrud2.dto.ProductDto;
import com.example.productcrud2.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {
    public ProductDto converter(Product product){
        ProductDto productDto= ProductDto.builder()
                .name(product.getName())
                .price(String.valueOf(product.getPrice()))
                .build();
        return productDto;
    }

}
