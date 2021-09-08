package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validate(String email, String password) {
        return userRepository.authentication(email, password);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> getList() {
        return (List<User>) userRepository.findAll();
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
