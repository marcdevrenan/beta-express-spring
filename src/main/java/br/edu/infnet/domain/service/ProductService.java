package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Product;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getList() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getList(User user) {
        return (List<Product>) productRepository.getProductByUserId(user.getId(), Sort.by(Sort.Direction.ASC, "name"));
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Integer getQty() {
        return (int) productRepository.count();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
