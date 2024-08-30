package dev.akash.fakestoreapi.DTOS;

import dev.akash.fakestoreapi.Models.Category;
import dev.akash.fakestoreapi.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    //the above apis are taken from fakestore api(JSON)

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);

        Category cat=new Category();
        cat.setTitle(category);  //set the title of the category
        product.setCategory(cat);   //assign the cat in the product table
        return product;
    }
}
