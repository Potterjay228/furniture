package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static ProductDaoImpl productDaoImpl=new ProductDaoImpl();

	@Override
    public void addProduct(Product product) {
		productDaoImpl.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
    	productDaoImpl.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
    	productDaoImpl.deleteProduct(productId);
    }

    @Override
    public Product getProductById(int productId) {
        return productDaoImpl.getProductById(productId);
    }

    /*@Override
    public List<Product> getAllProduct() {
        return productDaoImpl.getAllProduct();
    }*/
}