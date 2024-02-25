package in.madhav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.madhav.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

	List<Product> findByProductCategory(String productCategory);
}
