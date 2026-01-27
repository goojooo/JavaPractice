package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Product;
import utility.DBUtility;

public class ProductDaoImpl implements IProductDao {

    private static final String INSERT_SQL =
        "INSERT INTO products(product_name, price, quantity) VALUES(?,?,?)";

    private static final String SELECT_ALL =
        "SELECT * FROM products";

    private static final String SELECT_BY_ID =
        "SELECT * FROM products WHERE product_id=?";

    private static final String UPDATE_QTY =
        "UPDATE products SET quantity=? WHERE product_id=?";

    @Override
    public void addProduct(Product product) {
        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_SQL)
        ) {
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery()
        ) {
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

    @Override
    public Product getProductById(int productId) {

        Product product = null;

        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)
        ) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProductQuantity(int productId, int quantity) {
        try (
            Connection con = DBUtility.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_QTY)
        ) {
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
