package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Product;
import pojos.StockTransaction;
import utility.DBUtility;

public class StockDaoImpl implements IStockDao {

    private static final String INSERT_TXN =
        "INSERT INTO stock_transactions(product_id, change_qty, txn_type) VALUES(?,?,?)";

    private static final String STOCK_HISTORY =
        "SELECT * FROM stock_transactions ORDER BY txn_date DESC";

    private static final String LOW_STOCK =
        "SELECT * FROM products WHERE quantity < ?";

    @Override
    public void addStockTransaction(StockTransaction txn) {

        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_TXN)
        ) {
            ps.setInt(1, txn.getProductId());
            ps.setInt(2, txn.getChangeQty());
            ps.setString(3, txn.getTxnType());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StockTransaction> getStockHistory() {

        List<StockTransaction> list = new ArrayList<>();

        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(STOCK_HISTORY);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                list.add(new StockTransaction(
                        rs.getInt("txn_id"),
                        rs.getInt("product_id"),
                        rs.getInt("change_qty"),
                        rs.getString("txn_type"),
                        rs.getTimestamp("txn_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getLowStockProducts(int threshold) {

        List<Product> list = new ArrayList<>();

        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(LOW_STOCK)
        ) {
            ps.setInt(1, threshold);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
