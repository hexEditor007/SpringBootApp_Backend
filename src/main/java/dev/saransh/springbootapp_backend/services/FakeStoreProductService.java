package dev.saransh.springbootapp_backend.services;

import dev.saransh.springbootapp_backend.dtos.FakeStoreProductDto;
import dev.saransh.springbootapp_backend.dtos.ProductRequestDto;
import dev.saransh.springbootapp_backend.dtos.WrapperForFakeStoreProductService;
import dev.saransh.springbootapp_backend.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<WrapperForFakeStoreProductService> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET,null, WrapperForFakeStoreProductService.class);
        WrapperForFakeStoreProductService ad =  responseEntity.getBody();
//        List<FakeStoreProductDto> list = responseEntity.getBody().getData();
        return ad.toProductList();
//        return list;
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
