package dev.saransh.springbootapp_backend.controllers;

import dev.saransh.springbootapp_backend.dtos.FakeStoreProductDto;
import dev.saransh.springbootapp_backend.dtos.ProductRequestDto;
import dev.saransh.springbootapp_backend.models.Product;
import dev.saransh.springbootapp_backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) {
        Product p =  productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity;
        if(p == null){
            responseEntity  = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        } else {
            responseEntity  = new ResponseEntity<>(p, HttpStatus.OK);
        }

        return responseEntity;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImageURL(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice());

    }
}
