package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Clothing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository extends CrudRepository<Clothing, Integer> {

}
