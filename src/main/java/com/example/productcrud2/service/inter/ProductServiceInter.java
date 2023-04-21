package com.example.productcrud2.service.inter;

import com.example.productcrud2.dto.ProductDto;
import com.example.productcrud2.dto.request.CreateProductRequest;
import com.example.productcrud2.dto.request.UpdateProductRequest;
import com.example.productcrud2.dto.response.ProductResponse;
import com.example.productcrud2.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceInter {
     void createProduct(CreateProductRequest createProductRequest);
     ProductResponse getAllProducts();

     void updateProduct(Integer id, UpdateProductRequest product);
     void deleteProduct(Integer id) ;
}
