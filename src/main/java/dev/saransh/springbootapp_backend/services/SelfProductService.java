package dev.saransh.springbootapp_backend.services;

import dev.saransh.springbootapp_backend.exceptions.ProductNotFoundException;
import dev.saransh.springbootapp_backend.models.Category;
import dev.saransh.springbootapp_backend.models.Product;
import dev.saransh.springbootapp_backend.repositories.CategoryRepository;
import dev.saransh.springbootapp_backend.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public  SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    /*
    1. CategoryRepository interface extends JPA which is also an interface and is implemented by Hibernate and thus all method we are mentioning inside
       CategoryRepository(Interface) is already implemented by Hibernate.
    2. Since we are not writing any new methods we don't need to create and class that implements CategoryRepository(Interface) to implement the methods.
    3. Here spring will create an object(categoryRepository) of Hibernate and put it inside CategoryRepository interface.
    4. Since that object is in CategoryRepository interface context, it will only able to access the method that are defined in the particular interface.
     */

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String imageURL, String category, double price) {
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setImageURL(imageURL);
        p.setPrice(price);

        Category c = categoryRepository.findByTitle(category);
        if(c == null){
            c = new Category();
            c.setTitle(category);
        }

        p.setCategory(c);
        Product createdProduct = productRepository.save(p);
        return createdProduct;
    }
}
