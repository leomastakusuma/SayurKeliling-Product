package com.example.ESayurProduct.repository;

import com.example.ESayurProduct.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


public interface ProductRepositoryCustom {


    @Query(value="select *  from product p where p.id_product =:idProduct   ", nativeQuery=true)
    Product getByIDs(@Param("idProduct") Long idProduct);

    @Query(value="select *  from product p where p.id_user =:idUser   ", nativeQuery=true)
    List<Product> getProductByKangSayur(@Param("idUser") Long idUser);


    @Query(value="select *  from product p where p.id_kategori =:idKategori and  p.id_user =:idUser ", nativeQuery=true)
    List<Product> getByIDKategoris(@Param("idKategori") Long idKategori,@Param("idUser") Long idUser);

    @Query(value="select *  from product p where p.product_name LIKE %:keyword%  and p.id_user = :idUser  ", nativeQuery=true)
    List<Product> search(@Param("keyword") String keyword,@Param("idUser") Long idUser );



}
