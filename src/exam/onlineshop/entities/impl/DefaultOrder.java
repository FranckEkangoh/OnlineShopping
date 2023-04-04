package exam.onlineshop.entities.impl;

import exam.onlineshop.entities.Order;
import exam.onlineshop.entities.Product;


public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    public DefaultOrder(String creditCardNumber, Product[] products, int customerId) {
        this.creditCardNumber = creditCardNumber;
        this.products = products;
        this.customerId = customerId;
    }

    public DefaultOrder() {
        this("0000000000000000", null, 0);
    }

    @Override
    public boolean isCreditCardNumberValid() {
        if (creditCardNumber.length() != AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER) {
            return false;
        }
        boolean invalid = false;
        for (int i = 0; i < creditCardNumber.length(); i++) {
            switch (creditCardNumber.charAt(i)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> invalid = true;
                default -> invalid = false;
            }
        }
        return invalid;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        StringBuilder productList = new StringBuilder();
        for (Product product:this.products
             ) {
            if (product != null) {
                productList = new StringBuilder(productList + " " + product + "\n");
            } else {
                break;
            }
        }
        return "DefaultOrder{" +
                "customerId=" + customerId + "\n" +
                "creditCardNumber='" + creditCardNumber + '\'' + "\n" +
                ", products=" + productList +

                '}';
    }
}
