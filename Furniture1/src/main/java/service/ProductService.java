package service;

import java.util.List;

import model.Product;

public interface ProductService {
	
	void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    Product getProductById(int productId);
    //List<Product> getAllProduct();

}
