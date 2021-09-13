package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Grocery;
import br.edu.infnet.domain.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping(value = "/product/grocery")
    public String createGrocery() {
        return "/product/grocery/create";
    }

    @PostMapping(value = "/product/grocery/create")
    public String create(Model model, Grocery grocery) {
        groceryService.create(grocery);
        model.addAttribute("message", grocery.getName() + " has been added to system!");

        return getGroceryList(model);
    }

    @GetMapping(value = "/product/grocery/list")
    public String getGroceryList(Model model) {
        model.addAttribute("grocery", groceryService.getList());

        return "/product/grocery/list";
    }

    @GetMapping(value = "/product/grocery/{id}/delete")
    public String delete(Model model, @PathVariable Integer id) {
        Grocery grocery = groceryService.getById(id);
        groceryService.delete(id);
        model.addAttribute("message", grocery.getName() + " was successfully deleted!");

        return getGroceryList(model);
    }
}
