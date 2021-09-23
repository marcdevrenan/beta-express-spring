package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("from Customer c where c.user.id = :userId")
    public List<Customer> getList(Integer userId, Sort sort);
}
