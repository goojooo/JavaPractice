package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Product;
import utility.DBUtility;

public class ProductDaoImpl implements IProductDao {

    public boolean addProduct(Product product) {

        boolean status = false;

        try {
            Connection con = DBUtility.getConnection();

            String sql = "INSERT INTO products (product_name, price, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

	public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();

        try {
            Connection con = DBUtility.getConnection();

            String sql = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));

                productList.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

	@Override
	public List<Product> getLowStockProducts(int threshold) {

	    List<Product> lowStockList = new ArrayList<>();

	    try {
	        Connection con = DBUtility.getConnection();

	        String sql = "SELECT * FROM products WHERE quantity < ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, threshold);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Product product = new Product();
	            product.setProductId(rs.getInt("product_id"));
	            product.setProductName(rs.getString("product_name"));
	            product.setPrice(rs.getDouble("price"));
	            product.setQuantity(rs.getInt("quantity"));

	            lowStockList.add(product);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lowStockList;
	}

}
