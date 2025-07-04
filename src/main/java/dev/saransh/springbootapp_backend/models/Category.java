package dev.saransh.springbootapp_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore // to ignore any parameter from presenting itself in the final output. Here we are ignoring List<Product> to prevent nesting loop.
    List<Product> products;
    // It means if any category is deleted in Category table,
    // delete all the associated product that is referring to this category in the Products Table.
}
