package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Grocery;
import br.edu.infnet.domain.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public void create(Grocery grocery) {
        groceryRepository.save(grocery);
    }

    public List<Grocery> getList() {
        return (List<Grocery>) groceryRepository.findAll();
    }

    public Grocery getById(Integer id) {
        return groceryRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        groceryRepository.deleteById(id);
    }
}