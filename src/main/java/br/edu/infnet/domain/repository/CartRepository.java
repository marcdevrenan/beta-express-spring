package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Cart;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query("from Cart o where o.user.id = :userId")
    public List<Cart> getList(Integer userId, Sort sort);
}
