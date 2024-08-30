package dev.akash.fakestoreapi.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="Category")
public class Category extends BaseModel{

    private String title;
    @OneToMany(mappedBy = "category",cascade= CascadeType.REMOVE)
    private List<Product> products;
}
