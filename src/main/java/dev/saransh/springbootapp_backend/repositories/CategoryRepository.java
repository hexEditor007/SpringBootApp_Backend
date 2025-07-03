package dev.saransh.springbootapp_backend.repositories;

import dev.saransh.springbootapp_backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
Here JPA is an interface which is implemented by Hibernate
these methods are defined inside hibernate.

 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByTitle(String title);

//    List<Category> id(long id);
    /*
    these method names are not random and are implemented by Hibernate
    Internal working by Hibernate
    Select * from Category
    where title like 'title'

    Convert the returned row to Category object and return
     */
}
