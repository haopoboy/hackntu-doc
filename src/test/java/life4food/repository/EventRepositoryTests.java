package life4food.repository;

import javax.inject.Inject;

import life4food.Run;
import life4food.entity.Element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Run
public class EventRepositoryTests {
	
	@Inject ElementRepository elementRepository;
	@Inject EventRepository eventRepository;

	@Test
	public void findAll() {
		eventRepository.findAll();
	}
	
	@Test
	public void findByElementsContaining() {
		Element e = elementRepository.findByName("馬鈴薯");
//		eventRepository.findByElementsContaining( Arrays.asList(e) );
	}
}
