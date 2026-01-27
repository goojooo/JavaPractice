package dao;

import java.util.List;
import pojos.Product;

public interface IProductDao {

    void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void updateProductQuantity(int productId, int quantity);
}
