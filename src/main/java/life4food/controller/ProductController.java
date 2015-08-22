package life4food.controller;

import javax.inject.Inject;

import life4food.repository.ProductRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Inject ProductRepository productRepository;
	
	@RequestMapping("/{id}")
	public Object get(@PathVariable("id") Integer id) {
		return productRepository.findOne(id);
	}
}