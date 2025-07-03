package dev.saransh.springbootapp_backend.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private String imageURL;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
    // This means if a new product is added in Products Table with a category that doesn't yet exist in the Category Table,
    // add that category in the Category Table.
    private double price;

}
