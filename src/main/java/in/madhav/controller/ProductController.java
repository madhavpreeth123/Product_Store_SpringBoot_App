package in.madhav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.madhav.entity.Product;
import in.madhav.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		/*  
		 * This method is responsible to load empty product form
		 *	Product fields are mapped to product form
		 */
		
		model.addAttribute("products", new Product());
		return "index";
	}
	
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("products") Product product,BindingResult res,Model model) {
		
		/*
		 * Saving Product Data  
		 * 
		 */
		
		if(res.hasErrors()) {
			return "index";
		}
		
		boolean status = service.saveProduct(product);
		
		if(status) {
		model.addAttribute("msg", "Product Saved..");
		model.addAttribute("products", new Product());
		
		
		}
		
		return "index";
	}
	
	@GetMapping("/display")
	public String getAllProducts(Model model) {
		
		/*
		 * By default this method fetch all product information when we click on viewProducts  
		 */
		
		List<Product> allProducts = service.getAllProducts();
		
		model.addAttribute("products", allProducts);
		
		return "data";
	}
	
	
	@GetMapping("/edit")
	public String Edit(@RequestParam("productId") Integer productId,Model model) {
		
		/*
		 * Editing product data based on Product ID
		 */
		
		Product editProduct = service.editProduct(productId);
		
		model.addAttribute("products", editProduct);
		return "index";
		
		
	}
	
	@GetMapping("/delete")
	 public String delete(@RequestParam("productId") Integer productId,Model model) {
		
		/*
		 * Deleting product data based on Product ID
		 */
		
		List<Product> deleteProduct = service.deleteProduct(productId);
		
		model.addAttribute("msg", "Product Deleted");
		model.addAttribute("products", deleteProduct);
		 
		 
		 return "data";
	 }
	
	
	@GetMapping("/filteredData")
	public String filteredData(@RequestParam String productCategory,Model model) {
		
		
		/*
		 * Filtering product data based on selected Product Category
		 */
		
		List<Product> products = service.filterProductDataCategory(productCategory);
		
		model.addAttribute("products", products);
		
		return "filteredData";
		
	}
}
