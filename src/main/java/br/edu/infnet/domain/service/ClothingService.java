package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Clothing;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    public void create(Clothing clothing) {
        clothingRepository.save(clothing);
    }

    public List<Clothing> getList() {
        return (List<Clothing>) clothingRepository.findAll();
    }

    public List<Clothing> getList(User user) {
        return (List<Clothing>) clothingRepository.getClothingByUserId(user.getId());
    }

    public Clothing getById(Integer id) {
        return clothingRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        clothingRepository.deleteById(id);
    }
}
