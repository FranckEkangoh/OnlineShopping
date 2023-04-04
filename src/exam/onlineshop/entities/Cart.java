package exam.onlineshop.entities;

import exam.onlineshop.entities.impl.DefaultProduct;

public interface Cart {
    boolean isEmpty();

    void addProduct(Product product);

    Product[] getProducts();

    void clear();

}
