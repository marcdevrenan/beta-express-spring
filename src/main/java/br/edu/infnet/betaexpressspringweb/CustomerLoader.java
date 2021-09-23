package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.Customer;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CustomerLoader implements ApplicationRunner {

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setId(1);

        Customer customer = new Customer();
        customer.setFirstName("Lothric");
        customer.setLastName("Lorian");
        customer.setEmail("lothric@test.com");
        customer.setContact("01010101010");
        customer.setUser(user);

        customerService.create(customer);
        System.out.println("Customer " + customer.getFirstName() + " successfully added...");
    }
}
