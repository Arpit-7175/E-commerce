package dev.akash.fakestoreapi.Controllers;

import dev.akash.fakestoreapi.DTOS.FakeStoreProductDTO;
import dev.akash.fakestoreapi.Models.Product;
import dev.akash.fakestoreapi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;


    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate){
        this.productService=productService;
        this.restTemplate=restTemplate;
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }
    @Cacheable(value = "product")
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/products")
    public Product createProduct(@RequestBody FakeStoreProductDTO request){
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()

        );
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }

    @PatchMapping("/product/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody FakeStoreProductDTO request){
        return productService.updateProduct(
                productId,
                request.getTitle(),
                request.getPrice(),
                request.getCategory(),
                request.getDescription(),
                request.getImage()
        );

    }

}
