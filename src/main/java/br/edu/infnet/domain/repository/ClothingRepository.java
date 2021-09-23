package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Clothing;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends CrudRepository<Clothing, Integer> {

    @Query("from Clothing x where x.user.id = :userId")
    public List<Clothing> getClothingByUserId(Integer userId, Sort sort);
}
