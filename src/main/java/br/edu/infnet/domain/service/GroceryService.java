package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Grocery;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Grocery> getList(User user) {
        return (List<Grocery>) groceryRepository.getGroceryByUserId(user.getId(), Sort.by(Sort.Direction.ASC, "name"));
    }

    public Grocery getById(Integer id) {
        return groceryRepository.findById(id).orElse(null);
    }

    public Integer getQty() {
        return (int) groceryRepository.count();
    }

    public void delete(Integer id) {
        groceryRepository.deleteById(id);
    }
}
