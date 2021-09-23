package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("from Product p where p.user.id = :userId")
    public List<Product> getProductByUserId(Integer userId, Sort sort);
}
