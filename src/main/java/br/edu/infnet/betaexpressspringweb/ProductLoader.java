package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.Clothing;
import br.edu.infnet.domain.model.Electronic;
import br.edu.infnet.domain.model.Grocery;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.ClothingService;
import br.edu.infnet.domain.service.ElectronicService;
import br.edu.infnet.domain.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ProductLoader implements ApplicationRunner {

    @Autowired
    private ClothingService clothingService;

    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private GroceryService groceryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User();
        user.setId(1);

        Clothing c1 = new Clothing();
        c1.setName("T-shirt");
        c1.setPrice(15);
        c1.setQty(1);
        c1.setSize("GG");
        c1.setColor("blue");
        c1.setBrand(false);
        c1.setUser(user);

        clothingService.create(c1);
        System.out.println("Product " + c1.getName() + " successfully added...");

        Electronic e1 = new Electronic();
        e1.setName("SmartTV-43 UHD 4K");
        e1.setPrice(2499);
        e1.setQty(1);
        e1.setManufacturer("Samsung");
        e1.setVoltage(110);
        e1.setNational(false);
        e1.setUser(user);

        electronicService.create(e1);
        System.out.println("Product " + e1.getName() + " successfully added...");

        Grocery g1 = new Grocery();
        g1.setName("Kitkat Chocolate Bar");
        g1.setPrice(2);
        g1.setQty(1);
        g1.setDistributor("Nestle");
        g1.setWeight(42);
        g1.setUser(user);

        groceryService.create(g1);
        System.out.println("Product " + g1.getName() + " successfully added...");
    }
}
