package dev.saransh.springbootapp_backend.repositories;

import dev.saransh.springbootapp_backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product p);
}
