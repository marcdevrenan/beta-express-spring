package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setFirstName("Lorem");
        user.setLastName("Ipsum");
        user.setEmail("lorem@test.com");
        user.setPassword("1234");
        user.setAdmin(true);

        userRepository.save(user);
        System.out.println("Admin " + user.getFirstName() + " successfully added...");
    }
}
