package life4food.repository;

import javax.inject.Inject;

import life4food.Run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Run
public class ProductRepositoryTests {
	
	@Inject ProductRepository itemRepository;

	@Test
	public void findAll() {
		itemRepository.findAll().forEach(System.out::println);
	}
}
