package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {

	public static void main(String[] args) {
		

	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
    public void addProduct(Product product) {
        String sql = "insert into product (name, productno, price, amount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProductno());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, product.getAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "update product set name = ?, productno = ?, price = ?, amount = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProductno());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, product.getAmount());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        String sql = "delete from product where id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int productId) {
        String sql = "select * from product WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("productno"),
                    resultSet.getInt("price"),
                    resultSet.getInt("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*@Override
    public List<Product> getAllProduct() {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("productno"),
                    resultSet.getInt("price"),
                    resultSet.getInt("amount")
                );
                product.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product1;
    }*/
}