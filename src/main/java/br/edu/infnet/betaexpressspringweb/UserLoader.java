package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.Address;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UserLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address address = new Address();
        address.setCep("01010101");
        address.setLogradouro("matrix");
        address.setComplemento("complement");
        address.setBairro("district");
        address.setLocalidade("location");
        address.setUf("XX");

        User user = new User();
        user.setFirstName("Lorem");
        user.setLastName("Ipsum");
        user.setEmail("lorem@test.com");
        user.setPassword("1234");
        user.setAdmin(true);
        user.setAddress(user.getAddress());

        userRepository.save(user);
        System.out.println("Admin " + user.getFirstName() + " successfully added...");
    }
}
