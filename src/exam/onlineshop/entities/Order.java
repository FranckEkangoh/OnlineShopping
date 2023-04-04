package exam.onlineshop.entities;

import exam.onlineshop.entities.impl.DefaultProduct;

public interface Order {

    boolean isCreditCardNumberValid();

    void setCreditCardNumber(String userInput);

    void setProducts(Product[] products);

    void setCustomerId(int customerId);

    String getCreditCardNumber();

    Product[] getProducts();

    int getCustomerId();

}
