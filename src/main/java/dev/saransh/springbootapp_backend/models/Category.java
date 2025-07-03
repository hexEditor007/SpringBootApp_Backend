package dev.saransh.springbootapp_backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    List<Product> products;
    // It means if any category is deleted in Category table,
    // delete all the associated product that is referring to this category in the Products Table.
}
