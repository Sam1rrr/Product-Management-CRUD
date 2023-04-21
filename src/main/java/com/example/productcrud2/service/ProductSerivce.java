package com.example.productcrud2.service;

import com.example.productcrud2.dto.ProductDto;
import com.example.productcrud2.dto.request.CreateProductRequest;
import com.example.productcrud2.dto.request.UpdateProductRequest;
import com.example.productcrud2.dto.response.ProductResponse;
import com.example.productcrud2.entity.Product;
import com.example.productcrud2.repository.ProductRepository;
import com.example.productcrud2.service.inter.ProductServiceInter;
import com.example.productcrud2.util.ProductDtoConverter;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Service
@RequiredArgsConstructor
public class ProductSerivce implements ProductServiceInter {

private final ProductRepository productRepository;
private final ProductDtoConverter productDtoConverter;
    @Override
    public void createProduct(CreateProductRequest createProductRequest) {
        Product result=Product.builder()
                .name(createProductRequest.getName())
                .price(Double.parseDouble(createProductRequest.getPrice()))
                .build();
        productRepository.save(result);
    }
        @Override
    public ProductResponse getAllProducts(){
        List<ProductDto> productsDtoList=productRepository.findAll()
                .stream()
                .map(productDtoConverter::converter)
                .collect(Collectors.toList());
        return ProductResponse.builder()
                .productDtoList(productsDtoList)

                .build();



    }@Override
    public void updateProduct(Integer id, UpdateProductRequest product){
Product product1=productRepository.findById((int)id);
product1.setName(product.getName());
product1.setPrice(Double.parseDouble(product.getPrice()));
productRepository.save(product1);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product=productRepository.findById((int)id);
        productRepository.delete(product);

    }
}
