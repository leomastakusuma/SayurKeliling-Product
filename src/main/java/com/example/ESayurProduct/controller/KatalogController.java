package com.example.ESayurProduct.controller;

import com.example.ESayurProduct.model.Product;
import com.example.ESayurProduct.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@Api(tags = "Katalog")
@RequestMapping("/api/grobak")
public class KatalogController {

  @Autowired
  ProductRepository productRepository;

  @ApiOperation("View List ")
  @GetMapping("/{idGrobak}")
  public List<Product> listUser(@PathVariable(value = "idGrobak") Long idGrobak) {
    return productRepository.getProductByKangSayur(idGrobak);
  }

  @ApiOperation("View Product By Kategori ID")
  @GetMapping("/{idGrobak}/kategori/{idKategori}")
  public List<Product> getProductByKategori(@PathVariable(value = "idKategori") Long idKategori,@PathVariable(value = "idGrobak") Long idGrobak) {
    List<Product> product = productRepository.getByIDKategoris(idKategori,idGrobak);
    if(product ==null){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }else{
      return product;
    }
  }

  @ApiOperation("Searching Product")
  @GetMapping("/{idGrobak}/search")
  public List<Product> searchProduct(@RequestParam(required = false) String keyword,@PathVariable(value = "idGrobak") Long idGrobak) {
    List<Product> product = productRepository.search(keyword,idGrobak);
    if(product ==null){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }else{
      return product;
    }
  }

}
