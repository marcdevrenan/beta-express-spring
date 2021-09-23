package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Clothing;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @GetMapping(value = "/product/clothing")
    public String createClothing() {
        return "/product/clothing/create";
    }

    @PostMapping(value = "/product/clothing/create")
    public String create(Model model, Clothing clothing, @SessionAttribute("user") User user) {
        clothing.setUser(user);
        clothingService.create(clothing);
        model.addAttribute("message", clothing.getName() + " has been added to system!");

        return getClothingList(model, user);
    }

    @GetMapping(value = "/product/clothing/list")
    public String getClothingList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("clothing", clothingService.getList(user));

        return "/product/clothing/list";
    }

    @GetMapping(value = "/product/clothing/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user) {
        Clothing clothing = clothingService.getById(id);

        String message;
        try {
            clothingService.delete(id);
            message = "The product " + clothing.getName() + " was successfully deleted!";
        } catch (Exception e) {
            message = "It was impossible to delete the product " + clothing.getName();
        }

        model.addAttribute("message", message);

        return getClothingList(model, user);
    }
}
