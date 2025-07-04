package dev.saransh.springbootapp_backend;

import dev.saransh.springbootapp_backend.models.Product;
import dev.saransh.springbootapp_backend.projections.ProductProjection;
import dev.saransh.springbootapp_backend.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootAppBackendApplicationTests {

    @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testQueries(){
        List<ProductProjection> products = productRepository.getAllProductsWithCategoryId(3);
        for(ProductProjection product: products){
            System.out.println(product.getTitle());
            System.out.println(product.getId());
            System.out.println(product.getDescription());
        }
        System.out.println();
    }

}
