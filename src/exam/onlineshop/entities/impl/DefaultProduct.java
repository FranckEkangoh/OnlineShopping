package exam.onlineshop.entities.impl;

import exam.onlineshop.entities.Product;

public class DefaultProduct implements Product {

    private int id;
    private String productName;
    private String categoryName;
    private double price;
    private static int nbProducts;

    public DefaultProduct(String productName, String categoryName, double price) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
        this.id = ++nbProducts;
    }

    public DefaultProduct(DefaultProduct product) {
        this.productName = product.productName;
        this.categoryName = product.categoryName;
        this.price = product.price;
        this.id = ++nbProducts;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getPrice() {
        return price;
    }

    public static int getNbProducts() {
        return nbProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
