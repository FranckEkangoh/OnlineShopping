package exam.onlineshop.services.impl;

import exam.onlineshop.entities.Product;
import exam.onlineshop.entities.impl.DefaultProduct;
import exam.onlineshop.services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {
    private static DefaultProductManagementService instance;

    private static Product[] products;

    static {
        initProducts();
    }

    private static void initProducts() {
        products = new Product[] {
                new DefaultProduct("Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
                new DefaultProduct("Oregon Cottage Interior Oak Door", "Doors", 179.99),
                new DefaultProduct("Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
                new DefaultProduct("4 Panel Oak Deco Interior Door", "Doors", 209.09),
                new DefaultProduct("Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
                new DefaultProduct("Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
                new DefaultProduct("Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
                new DefaultProduct("Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
                new DefaultProduct("Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
                new DefaultProduct("Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
        };
    }

    private DefaultProductManagementService() {

    }

    public static ProductManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultProductManagementService();
        }
        return instance;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        for (Product product:products
             ) {
            if (product.getId() == productIdToAddToCart) {
                return product;
            }
        }
        return null;
    }
}
