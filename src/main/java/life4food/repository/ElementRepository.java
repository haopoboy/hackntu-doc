package life4food.repository;

import life4food.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface ElementRepository extends CrudRepository<Product, Integer> {
}
