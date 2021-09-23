package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Grocery;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Integer> {

    @Query("from Grocery g where g.user.id = :userId")
    public List<Grocery> getGroceryByUserId(Integer userId, Sort sort);
}
