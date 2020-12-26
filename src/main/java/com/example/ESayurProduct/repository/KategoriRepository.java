package com.example.ESayurProduct.repository;

import com.example.ESayurProduct.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepository extends JpaRepository<Kategori,Long>,KategoriRepositoryCustom {
}
