package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> getProductByUserId(Integer id);
}
