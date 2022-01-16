package com.example.final1;

public class ProductModel {
    private String productID;
    private String productName;
    private String productPrice;
    private int soluongdathang;

    public ProductModel(String productID, String productName, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;

    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getSoluongdathang() {
        return soluongdathang;
    }

    public void setSoluongdathang(int soluongdathang) {
        this.soluongdathang = soluongdathang;
    }

    public ProductModel() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
