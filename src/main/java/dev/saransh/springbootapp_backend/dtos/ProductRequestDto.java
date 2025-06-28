package dev.saransh.springbootapp_backend.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
