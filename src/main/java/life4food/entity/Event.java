package life4food.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Event {
	
	private Integer id;
	private Type type = Type.NONE; 
	private List<Element> elements = Lists.newArrayList();
	private String description;
}
