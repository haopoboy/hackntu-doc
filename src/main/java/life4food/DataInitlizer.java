package life4food;

import java.util.List;

import javax.inject.Inject;

import life4food.entity.Element;
import life4food.entity.Product;
import life4food.entity.Type;
import life4food.repository.ProductRepository;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class DataInitlizer {
	
	@Inject ProductRepository productRepository;

	public void insertAll() {
		List<Product> products = Lists.newArrayList(
				new Product()
					.setName("伯朗咖啡")
					.addElement( new Element().setName("咖啡因").setType(Type.ADVANTAGE).setDescription("有益睡眠") )
					.addElement( new Element().setName("奶精").setType(Type.DISADVANTAGE).setDescription("容易有尿意") )
					,
				new Product()
					.setName("樂事")
					.addElement( new Element().setName("馬鈴薯") )
					.addElement( new Element().setName("玉米粉") )
				);
		
		productRepository.save(products);
	}

}
