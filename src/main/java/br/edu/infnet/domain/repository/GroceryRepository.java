package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Grocery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Integer> {
}
