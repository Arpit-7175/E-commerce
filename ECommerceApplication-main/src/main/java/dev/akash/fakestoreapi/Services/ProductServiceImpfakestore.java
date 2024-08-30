package dev.akash.fakestoreapi.Services;

import dev.akash.fakestoreapi.DTOS.FakeStoreProductDTO;
import dev.akash.fakestoreapi.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("ProductServiceImpfakestore")
public class ProductServiceImpfakestore implements  ProductService{

    RestTemplate restTemplate;
    //constructor
    @Autowired
    public ProductServiceImpfakestore(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        //first we need to call the URL of fakestore through rest template
        //return the product so that we can see it in postman or google chrome
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("Https://fakestoreapi.com/products/" + productId, FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }



    @Override
    public List<Product> getAllProducts() {
        List<Product> productList=new ArrayList<>();
        FakeStoreProductDTO[] fakeStoreProductDTO=restTemplate.getForObject("Https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
      //for loop to fill our product list from fakeStoreProductDTO[]
        for(int i=0;i<fakeStoreProductDTO.length;i++){
            productList.add(fakeStoreProductDTO[i].toProduct());
        }
        return productList;
    }


    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(category);
        FakeStoreProductDTO response = restTemplate.postForObject("Https://fakestoreapi.com/products", fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response.toProduct();
    }
    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete("Https://fakestoreapi.com/products"+productId);
    }

    @Override
    public Product updateProduct(Long productId, String title, double price, String description, String image, String category) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(category);
        FakeStoreProductDTO response = restTemplate.patchForObject("Https://fakestoreapi.com/products", fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response.toProduct();
    }


    @Override
    public List<Product> getProductByCategory(String category) {
        return null;
    }
}
