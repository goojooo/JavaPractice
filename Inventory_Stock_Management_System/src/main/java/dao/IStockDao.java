package dao;

import java.util.List;
import pojos.StockTransaction;
import pojos.Product;

public interface IStockDao {

    void addStockTransaction(StockTransaction txn);
    List<StockTransaction> getStockHistory();
    List<Product> getLowStockProducts(int threshold);
}
