package com.example.ESayurProduct.repository;
import com.example.ESayurProduct.model.Product;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class ProductRepositoryImpl implements  ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getByIDs(Long idProduct) {
        return null;
    }

    @Override
    public List<Product> getProductByKangSayur(Long idUser) {
        return null;
    }

    @Override
    public List<Product> getByIDKategoris(Long idKategori,Long idUser) {
        return null;
    }

    @Override
    public List<Product> search(String keyword,Long idUser) {
        return null;
    }







}
