package life4food.controller;

import java.util.List;

import javax.inject.Inject;

import life4food.entity.Product;
import life4food.repository.EventRepository;
import life4food.repository.ProductRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
	
	public static class EventRequest {
		private List<Integer> productIds;

		public List<Integer> getProductIds() {
			return productIds;
		}

		public EventRequest setProductIds(List<Integer> productIds) {
			this.productIds = productIds;
			return this;
		}
	}
	
	@Inject ProductRepository productRepository;
	@Inject EventRepository eventRepository;
	
	@RequestMapping(value = "/analysis", method = RequestMethod.POST)
	public Object find(EventRequest request) {
		Iterable<Product> proudcts = productRepository.findAll( request.getProductIds() );
		return eventRepository.findAll();
	}
}