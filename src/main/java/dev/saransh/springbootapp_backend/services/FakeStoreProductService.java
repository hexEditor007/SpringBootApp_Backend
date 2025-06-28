package dev.saransh.springbootapp_backend.services;

import dev.saransh.springbootapp_backend.dtos.FakeStoreProductDto;
import dev.saransh.springbootapp_backend.dtos.ProductRequestDto;
import dev.saransh.springbootapp_backend.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(ProductRequestDto productRequestDto) {
        return null;
    }
}
