package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.*;
import br.edu.infnet.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class CartLoader implements ApplicationRunner {

    @Autowired
    private CartService cartService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setId(1);

        Customer customer = new Customer();
        customer.setId(1);

        Clothing c1 = new Clothing();
        c1.setId(1);

        Electronic e1 = new Electronic();
        e1.setId(2);

        Grocery g1 = new Grocery();
        g1.setId(3);

        List<Product> products = new ArrayList<Product>();
        products.add(c1);
        products.add(e1);
        products.add(g1);

        Cart cart = new Cart();
        cart.setDescription("My christmas cart");
        cart.setProducts(products);
        cart.setCustomer(customer);
        cart.setUser(user);

        cartService.create(cart);
        System.out.println(cart.getDescription() + " successfully added...");

    }
}
