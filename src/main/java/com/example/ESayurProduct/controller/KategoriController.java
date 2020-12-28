package com.example.ESayurProduct.controller;

import com.example.ESayurProduct.form.KategoriForm;
import com.example.ESayurProduct.model.Kategori;
import com.example.ESayurProduct.repository.KategoriRepository;
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
@Api(tags = "Kategori")
@RequestMapping("/api/kategori")
public class KategoriController {
    @Autowired
    KategoriRepository kategoriRepository;

    @ApiOperation("View List Kategory")
    @GetMapping("/")
    public List<Kategori> listUser() {
        return kategoriRepository.findAll();
    }

    @ApiOperation("Create Kategori ")
    @PostMapping("/")
    public Kategori createKategory(@Valid @RequestBody KategoriForm kategoriForm) {
        Kategori kategori = new Kategori();
        kategori.setKategori(kategoriForm.getKategori());
        return kategoriRepository.save(kategori);
    }

    @ApiOperation("View Kategori By ID")
    @GetMapping("/{idKategori}")
    public Kategori getUserByPhone(@PathVariable(value = "idKategori") Long idKategori) {
        Kategori kategori = kategoriRepository.findCategoryId(idKategori);
        if(kategori ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return kategori;
        }
    }
    @ApiOperation("Update User By ID")
    @PutMapping("/{idKategori}")
    public Kategori updateUser(@PathVariable(value = "idKategori") Long idKategori, @Valid @RequestBody KategoriForm kategoriForm) {
        Kategori kategoriData = kategoriRepository.findById(idKategori).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        kategoriData.setKategori(kategoriForm.getKategori());
        return kategoriRepository.save(kategoriData);
    }


    @DeleteMapping("/{idKategori}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "idKategori") Long idKategori) {
        Kategori kategori = kategoriRepository.findCategoryId(idKategori);
        if(kategori ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            kategoriRepository.delete(kategori);
            return ResponseEntity.ok().build();
        }


    }
}
