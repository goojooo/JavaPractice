package dao;

import java.util.List;

import pojos.StockTransaction;

public interface IStockDao {
	boolean updateStock(int productId, int qty, String type);
	List<StockTransaction> getStockHistory();
}
