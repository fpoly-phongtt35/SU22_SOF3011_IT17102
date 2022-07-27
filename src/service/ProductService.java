package service;

import java.util.List;

import model.Product;
import repository.ProductRepository;

public class ProductService {
	
	private final ProductRepository productRepo;
	
	public ProductService() {
		productRepo = new ProductRepository();
	}
	
	public List<Product> getAllProduct() {
		return productRepo.getAll();
	}
}
