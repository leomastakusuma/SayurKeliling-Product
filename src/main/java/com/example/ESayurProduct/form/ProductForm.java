package com.example.ESayurProduct.form;

public class ProductForm {


  private String productName;

  private String Price;

  private Long idKategori;

  private Long idUser;


  public Long getIdUser() {
    return idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPrice() {
    return Price;
  }

  public void setPrice(String Price) {
    this.Price = Price;
  }

  public Long getIdKategori() {
    return idKategori;
  }

  public void setIdKategori(Long idKategori) {
    this.idKategori = idKategori;
  }


}
