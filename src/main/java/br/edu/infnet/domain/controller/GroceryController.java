package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Grocery;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping(value = "/product/grocery")
    public String createGrocery() {
        return "/product/grocery/create";
    }

    @PostMapping(value = "/product/grocery/create")
    public String create(Model model, Grocery grocery, @SessionAttribute("user") User user) {
        grocery.setUser(user);
        groceryService.create(grocery);
        model.addAttribute("message", grocery.getName() + " has been added to system!");

        return getGroceryList(model, user);
    }

    @GetMapping(value = "/product/grocery/list")
    public String getGroceryList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("grocery", groceryService.getList(user));

        return "/product/grocery/list";
    }

    @GetMapping(value = "/product/grocery/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user) {
        Grocery grocery = groceryService.getById(id);

        String message;
        try {
            groceryService.delete(id);
            message = "The product " + grocery.getName() + " was successfully deleted!";
        } catch (Exception e) {
            message = "It was impossible to delete the product " + grocery.getName();
        }

        model.addAttribute("message", message);

        return getGroceryList(model, user);
    }
}
