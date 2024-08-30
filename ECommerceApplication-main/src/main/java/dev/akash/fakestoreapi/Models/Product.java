package dev.akash.fakestoreapi.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private Double price;
    private String description;
    private String imageURL;

    @ManyToOne(cascade={CascadeType.PERSIST})
    private Category category;

}
