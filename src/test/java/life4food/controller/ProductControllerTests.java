package life4food.controller;

import life4food.RunWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@RunWebApp
public class ProductControllerTests {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void get() {
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:8080/product/{id}", String.class, 1);
		System.out.println(entity.getBody());
	}
}
