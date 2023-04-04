package exam.onlineshop.services;

import exam.onlineshop.entities.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);


}
