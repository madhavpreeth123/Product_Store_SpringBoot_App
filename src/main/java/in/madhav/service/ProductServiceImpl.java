package in.madhav.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.madhav.entity.Product;
import in.madhav.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public boolean saveProduct(Product product) {

		product.setTotalPrice(product.getProductQuatity() * product.getProductPrice());

		product = productRepo.save(product);

		if (product.getProductId() != null) {

			return true;
		}

		return false;
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepo.findAll();
	}

	@Override
	public List<Product> deleteProduct(Integer productId) {

		productRepo.deleteById(productId);

		return productRepo.findAll();
	}

	@Override
	public Product editProduct(Integer productId) {

		Optional<Product> findById = productRepo.findById(productId);

		if (findById.isPresent()) {

			return findById.get();
		}

		return new Product();
	}

	
	@Override
	public List<Product> filterProductDataCategory(String productCategory) {
		
		List<Product> products = productRepo.findByProductCategory(productCategory);
		
		return products;
	}
}
