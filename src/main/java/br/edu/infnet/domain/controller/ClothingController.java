package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Clothing;
import br.edu.infnet.domain.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @GetMapping(value = "/product/clothing")
    public String createClothing() {
        return "/product/clothing/create";
    }

    @PostMapping(value = "/product/clothing/create")
    public String create(Model model, Clothing clothing) {
        clothingService.create(clothing);
        model.addAttribute("message", clothing.getName() + " has been added to system!");

        return getClothingList(model);
    }

    @GetMapping(value = "/product/clothing/list")
    public String getClothingList(Model model) {
        model.addAttribute("clothing", clothingService.getList());

        return "/product/clothing/list";
    }

    @GetMapping(value = "/product/clothing/{id}/delete")
    public String delete(Model model, @PathVariable Integer id) {
        Clothing clothing = clothingService.getById(id);
        clothingService.delete(id);
        model.addAttribute("message", clothing.getName() + " was successfully deleted!");

        return getClothingList(model);
    }
}
