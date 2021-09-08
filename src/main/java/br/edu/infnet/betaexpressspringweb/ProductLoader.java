package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.model.Clothing;
import br.edu.infnet.domain.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements ApplicationRunner {

    @Autowired
    private ClothingService clothingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Clothing c1 = new Clothing();
//        c1.setName("T-shirt");
//        c1.setPrice(15);
//        c1.setQty(1);
//        c1.setSize("GG");
//        c1.setColor("blue");
//        c1.setBrand(false);
//
//        clothingService.create(c1);
//
//        Clothing c2 = new Clothing();
//        c2.setName("Jacket");
//        c2.setPrice(50);
//        c2.setQty(1);
//        c2.setSize("GG");
//        c2.setColor("brown");
//        c2.setBrand(true);
//
//        clothingService.create(c2);
//
//        for (Clothing c : clothingService.getList()) {
//            System.out.println(c);
//        }
//
//        clothingService.delete(1);
//
//        for (Clothing c : clothingService.getList()) {
//            System.out.println(c);
//        }
//
//        Clothing c3 = clothingService.getById(2);
//
//        System.out.println(c3.getName());
    }
}
