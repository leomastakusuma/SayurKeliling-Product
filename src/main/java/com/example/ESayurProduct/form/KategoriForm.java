package com.example.ESayurProduct.form;

import javax.validation.constraints.NotBlank;


public class KategoriForm {


  @NotBlank
  private String kategori;

  public String getKategori() {
    return kategori;
  }

  public void setKategori(String kategori) {
    this.kategori = kategori;
  }

}
