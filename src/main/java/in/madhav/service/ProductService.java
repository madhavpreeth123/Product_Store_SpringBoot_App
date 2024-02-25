package in.madhav.service;

import java.util.List;

import in.madhav.entity.Product;

public interface ProductService {

	
	public boolean saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product editProduct(Integer productId);
	
	public List<Product> deleteProduct(Integer productId);
	
	public List<Product>  filterProductDataCategory(String productCategory);
}
