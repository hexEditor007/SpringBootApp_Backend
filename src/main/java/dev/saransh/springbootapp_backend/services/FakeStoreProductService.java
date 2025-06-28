package dev.saransh.springbootapp_backend.services;

import dev.saransh.springbootapp_backend.dtos.FakeStoreProductDto;
import dev.saransh.springbootapp_backend.dtos.ProductRequestDto;
import dev.saransh.springbootapp_backend.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<List<FakeStoreProductDto>> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET,null, new ParameterizedTypeReference<List<FakeStoreProductDto>>() {});
//        WrapperForFakeStoreProductService ad =  responseEntity.getBody();
        List<FakeStoreProductDto> list = responseEntity.getBody();
        List<Product> newList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : list) {
            newList.add(fakeStoreProductDto.toProduct());
        }
//        System.out.println(list);
        return newList;

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
