package com.example.productcrud2.controller;

import com.example.productcrud2.dto.ProductDto;
import com.example.productcrud2.dto.request.CreateProductRequest;
import com.example.productcrud2.dto.request.UpdateProductRequest;
import com.example.productcrud2.entity.Product;
import com.example.productcrud2.service.inter.ProductServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gradiant",method = RequestMethod.POST)
@RequiredArgsConstructor

public class  ProductController   {
private  final ProductServiceInter productServiceInter;


 @PostMapping("/register")
 @ResponseStatus(HttpStatus.OK)
private void create(@RequestBody CreateProductRequest product){
productServiceInter.createProduct(product);
}
@PostMapping("/products")
 @ResponseStatus(HttpStatus.OK)
public List<ProductDto> readAllProducts(){

return productServiceInter.getAllProducts();

 }
 @PatchMapping("/update/{id}")
 @ResponseStatus(HttpStatus.ACCEPTED)
 public void update(@PathVariable Integer  id ,@RequestBody UpdateProductRequest product){
  productServiceInter.updateProduct(id , product);
 }
 @DeleteMapping("/delete/{id}")
 @ResponseStatus(HttpStatus.ACCEPTED)
 public void delete(@PathVariable Integer id){
  productServiceInter.deleteProduct(id);

 }
}
