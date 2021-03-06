package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Electronic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicRepository extends CrudRepository<Electronic, Integer> {

    @Query("from Electronic e where  e.user.id = :userId")
    public List<Electronic> getElectronicByUserId(Integer userId, Sort sort);
}
