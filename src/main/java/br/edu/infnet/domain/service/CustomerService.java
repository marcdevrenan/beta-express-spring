package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Customer;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getList() {
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Customer> getList(User user) {
        return customerRepository.getList(user.getId(), Sort.by(Sort.Direction.ASC, "firstName"));
    }

    public Customer getById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Integer getQty() {
        return (int) customerRepository.count();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
