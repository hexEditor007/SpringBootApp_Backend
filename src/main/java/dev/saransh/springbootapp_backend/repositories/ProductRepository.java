package dev.saransh.springbootapp_backend.repositories;

import dev.saransh.springbootapp_backend.models.Category;
import dev.saransh.springbootapp_backend.models.Product;
import dev.saransh.springbootapp_backend.projections.ProductProjection;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product p);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Title(String categoryTitle);

    List<Product> findAllByCategory_Id(long categoryId);

    List<Product> findByTitleStartingWith(String startingWith);

    List<Product> findByTitleStartingWithAndIdEquals(String startingWith, long id);

    //Hibernate Query Language(HQL)
    // Treat variables as parameters inside class and not columns in table
    // It will return only title and id columns
    @Query("select p.title as title, p.id as id from Product p where p.category.title = :categoryName")
    List<ProductProjection> getTitlesAndIdOFAllProductsWithGivenCategoryTitle(@Param("categoryName") String categoryName);

    //Native SQL
    // Treat variables as columns inside the table
    // It will return all columns
    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<ProductProjection> getAllProductsWithCategoryId(@Param("categoryId") long categoryId);
}
