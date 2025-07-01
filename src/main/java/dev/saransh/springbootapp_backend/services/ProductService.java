package dev.saransh.springbootapp_backend.services;

import dev.saransh.springbootapp_backend.dtos.FakeStoreProductDto;
import dev.saransh.springbootapp_backend.dtos.ProductRequestDto;
import dev.saransh.springbootapp_backend.exceptions.ProductNotFoundException;
import dev.saransh.springbootapp_backend.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product createProduct(String title, String description, String imageURL, String category, double price);


}
