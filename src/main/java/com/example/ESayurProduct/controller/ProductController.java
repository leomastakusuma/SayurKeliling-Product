package com.example.ESayurProduct.controller;

import com.example.ESayurProduct.model.Kategori;
import com.example.ESayurProduct.model.Product;
import com.example.ESayurProduct.repository.KategoriRepository;
import com.example.ESayurProduct.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Product")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    KategoriRepository kategoriRepository;

    @ApiOperation("View List Product")
    @GetMapping("/")
    public List<Product> listUser() {
        return productRepository.findAll();
    }

    @ApiOperation("Create Product ")
    @PostMapping("/")
    public Product createKategory(@Valid @RequestBody Product product) {
        Kategori kategoriData = kategoriRepository.findCategoryId(product.getIdKategori());
        if(kategoriData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return productRepository.save(product);
       }
    }
    @ApiOperation("View Product By ID")
    @GetMapping("/{idProduct}")
    public Product getProductById(@PathVariable(value = "idProduct") Long idProduct) {
        Product product = productRepository.getByIDs(idProduct);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }



    @ApiOperation("Update Product By ID")
    @PutMapping("/{idProduct}")
    public Product updateUser(@PathVariable(value = "idProduct") Long idProduct, @Valid @RequestBody Product product) {

        Product productData = productRepository.getByIDs(idProduct);
        if(productData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            productData.setIdKategori(product.getIdKategori());
            productData.setProductName(product.getProductName());
            productData.setPrice(product.getPrice());
            return productRepository.save(productData);
        }
    }
    @ApiOperation("Delete Product")
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "idProduct") Long idProduct) {
        Product product = productRepository.getByIDs(idProduct);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            productRepository.deleteById(idProduct);
            return ResponseEntity.ok().build();
        }
    }
}
