package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Electronic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicRepository extends CrudRepository<Electronic, Integer> {

    public List<Electronic> getElectronicByUserId(Integer id);
}
