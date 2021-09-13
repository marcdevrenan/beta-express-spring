package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Electronic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicRepository extends CrudRepository<Electronic, Integer> {
}
