package life4food;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import life4food.entity.Element;
import life4food.entity.Event;
import life4food.entity.Product;
import life4food.entity.Type;
import life4food.repository.ElementRepository;
import life4food.repository.EventRepository;
import life4food.repository.ProductRepository;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class DataInitlizer {
	
	@Inject ElementRepository elementRepository;
	@Inject EventRepository eventRepository;
	@Inject ProductRepository productRepository;

	@Transactional
	public void insertAll() {
		Element rise = new Element().setName("特級壽司米")
			.setAdvDescription("供應澱粉，為人體所需五大營養素之ㄧ，提供熱量")
			.setDisadvDescription("食用過多會造成加速血糖上升，增加心血管疾病發生的風險")
			;
		
		Element fish = new Element().setName("鮪魚")
			.setAdvDescription("內含豐富的DHA和EPA，可預防心血管疾病、大腦老化等")
			.setDisadvDescription("鮪魚屬大型魚類，可能會累積相對更多的毒素在體內")
			;
		Element vege = new Element()
			.setName("蔬菜")
			.setAdvDescription("人體所需五大營養素之ㄧ，促進排便")
			;
		Element colhol = new Element()
			.setName("酒精")
			.setAdvDescription("擴張血管，降低心血管疾病，腦中風，糖尿病的風險，利尿，促進新陳代謝")
			.setDisadvDescription("長期飲用下將導致認知能力下降，營養素缺乏，肝臟病變，高血壓，過量甚至恐致腦猝死")
			;
		Element flower = new Element()
			.setName("啤酒花")
			.setAdvDescription("減輕焦慮，刺激食慾，對血管疾病，機能亢進，失眠症，神經過敏，疼痛，焦慮，性慾疾病，休克，壓力，牙痛，潰瘍均有效")
			;
		Element color = new Element()
			.setName("天然色素")
			.setDisadvDescription("長期累積過量食用將導致慢性中毒")
			;
		Element nameSalt = new Element()
			.setName("亞硝酸鹽")
			.setDisadvDescription("大量食用導致慢性中毒，包含變性血紅素症，烏嘴病（enterogenous cyanosis)，腸胃炎，呼吸困難，意識不清")
			;
		Element binder = new Element()
			.setName("結著劑(Binders)")
			.setDisadvDescription("主成份為磷酸鹽類，對腎造成負擔")
			;
		Element bacteria = new Element()
			.setName("乳酸菌")
			.setAdvDescription("維持腸道健康，促進消化吸收，防止壞菌在腸道滋生")
			;
		Element sugar = new Element()
			.setName("果糖液糖")
			.setDisadvDescription("過量攝取將造成新陳代謝症候群，罹癌機率上升，上癮，蛀牙")
			;
		List<Element> elements = Lists.newArrayList(rise, fish, vege, colhol, color, nameSalt, binder, bacteria, sugar);
		elementRepository.save(elements);
		
		Product pFish = new Product()
			.setName("鮪魚夾心飯糰")
			.addElements(rise, fish, vege)
			;
		Product pCohol = new Product()
			.setName("啤酒")
			.addElements(colhol, flower, color)
			;
		Product pColon = new Product()
			.setName("香腸")
			.addElements(nameSalt, binder)
			;
		Product pMuchMuch = new Product()
			.setName("養樂多")
			.addElements(bacteria, sugar)
			;
			
		List<Product> products = Lists.newArrayList(pFish, pCohol, pColon, pMuchMuch);
		productRepository.save(products);
		
		Event e1 = new Event()
			.setType(Type.DISADVANTAGE)
			.setName("當香腸遇到養樂多")
			.setLeftProduct(pColon)
			.setRightProduct(pMuchMuch)
			.setDescription("香腸中的亞硝酸鹽，在酸性中與乳酸菌作用，會產生亞硝胺，其為強烈致癌物")
			;
		
		Event e2 = new Event()
			.setType(Type.DISADVANTAGE)
			.setName("當鮪魚遇到啤酒")
			.setLeftProduct(pFish)
			.setRightProduct(pCohol)
			.setDescription("鮪魚中的嘌呤會正常代謝成尿酸，而啤酒在體內代謝後的產物乙酸會跟尿酸競爭同一代謝管道，導致尿酸無法盡速排除而在體內堆積，當濃度過高時便會產生結晶，造成痛風")
			.setNotification("其實很多食物都有嘌呤(蛋豆魚肉類)，因此只要是高普林含量的食物就應避免與酒同時攝取")
			;
		List<Event> events = Lists.newArrayList(e1, e2);
		eventRepository.save(events);
	}

}
