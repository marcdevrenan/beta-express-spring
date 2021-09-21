package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Electronic;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.ElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicService {

    @Autowired
    private ElectronicRepository electronicRepository;

    public void create(Electronic electronic) {
        electronicRepository.save(electronic);
    }

    public List<Electronic> getList() {
        return (List<Electronic>) electronicRepository.findAll();
    }

    public List<Electronic> getList(User user) {
        return (List<Electronic>) electronicRepository.getElectronicByUserId(user.getId());
    }

    public Electronic getById(Integer id) {
        return electronicRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        electronicRepository.deleteById(id);
    }
}
