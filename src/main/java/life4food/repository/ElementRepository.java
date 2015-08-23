package life4food.repository;

import life4food.entity.Element;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Integer> {
	Element findByName(String name);
}
