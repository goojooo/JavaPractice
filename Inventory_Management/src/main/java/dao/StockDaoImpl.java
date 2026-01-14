package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.StockTransaction;
import utility.DBUtility;

public class StockDaoImpl implements IStockDao {

    @Override
    public boolean updateStock(int productId, int qty, String type) {

        boolean status = false;

        Connection con = null;

        try {
            con = DBUtility.getConnection();
            con.setAutoCommit(false); // start transaction

            String updateSql;

            if ("IN".equals(type)) {
                updateSql = "UPDATE products SET quantity = quantity + ? WHERE product_id = ?";
            } else {
                updateSql = "UPDATE products SET quantity = quantity - ? WHERE product_id = ?";
            }

            PreparedStatement ps1 = con.prepareStatement(updateSql);
            ps1.setInt(1, qty);
            ps1.setInt(2, productId);
            ps1.executeUpdate();

            String historySql = "INSERT INTO stock_transactions (product_id, change_qty, transaction_type) VALUES (?, ?, ?)";
            PreparedStatement ps2 = con.prepareStatement(historySql);
            ps2.setInt(1, productId);
            ps2.setInt(2, qty);
            ps2.setString(3, type);
            ps2.executeUpdate();

            con.commit();
            status = true;

        } catch (Exception e) {
            try {
                if (con != null) con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<StockTransaction> getStockHistory() {

        List<StockTransaction> historyList = new ArrayList<>();

        try {
            Connection con = DBUtility.getConnection();

            String sql = "SELECT * FROM stock_transactions ORDER BY transaction_date DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StockTransaction st = new StockTransaction();
                st.setTransactionId(rs.getInt("transaction_id"));
                st.setProductId(rs.getInt("product_id"));
                st.setChangeQty(rs.getInt("change_qty"));
                st.setTransactionType(rs.getString("transaction_type"));
                st.setTransactionDate(rs.getTimestamp("transaction_date"));

                historyList.add(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return historyList;
    }

}
