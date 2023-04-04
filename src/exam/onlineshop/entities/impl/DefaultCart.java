package exam.onlineshop.entities.impl;

import exam.onlineshop.entities.Cart;
import exam.onlineshop.entities.Product;

public class DefaultCart implements Cart {
    private final static int MAXIMUM_PRODUCT_IN_CART = 20;
    private int nbOfProduct;
    private DefaultProduct[] productsInCart;

    public DefaultCart() {
        clear();
    }

    @Override
    public boolean isEmpty() {
        for (Product product:productsInCart
             ) {
            if (product != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addProduct(Product product) {
        this.productsInCart[nbOfProduct++] = (DefaultProduct) product;
    }

    @Override
    public Product[] getProducts() {
       return productsInCart;
    }

    @Override
    public void clear() {
        this.nbOfProduct = 0;
        this.productsInCart = new DefaultProduct[MAXIMUM_PRODUCT_IN_CART];
    }
}
