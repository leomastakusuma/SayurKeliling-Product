package com.example.ESayurProduct.repository;

import com.example.ESayurProduct.model.Kategori;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  KategoriRepositoryCustom {



    @Query(value="select * from kategori k where k.id_kategori =:idKategory    order by k.id_kategori desc  limit 1 ", nativeQuery=true)
    Kategori findCategoryId(@Param("idKategory") Long idKategory);

    @Query(value="delete  from kategori k where k.id_kategori =:idKategori  ", nativeQuery=true)
    Kategori deleteByID(@Param("idKategori") Long idKategori);



}
