package dao;

import java.util.List;
import pojos.Product;

public interface IProductDao {

    boolean addProduct(Product product);

    List<Product> getAllProducts();
    List<Product> getLowStockProducts(int threshold);
}
