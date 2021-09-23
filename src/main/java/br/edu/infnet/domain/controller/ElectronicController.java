package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Electronic;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping(value = "/product/electronic")
    public String createElectronic() {
        return "/product/electronic/create";
    }

    @PostMapping(value = "/product/electronic/create")
    public String create(Model model, Electronic electronic, @SessionAttribute("user") User user) {
        electronic.setUser(user);
        electronicService.create(electronic);
        model.addAttribute("message", electronic.getName() + " has been added to system!");

        return getElectronicList(model, user);
    }

    @GetMapping(value = "/product/electronic/list")
    public String getElectronicList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("electronic", electronicService.getList(user));

        return "/product/electronic/list";
    }

    @GetMapping(value = "/product/electronic/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user) {
        Electronic electronic = electronicService.getById(id);

        String message;
        try {
            electronicService.delete(id);
            message = "The product " + electronic.getName() + " was successfully deleted!";

        } catch (Exception e) {
            message = "It was impossible to delete the product " + electronic.getName();
        }

        model.addAttribute("message", message);

        return getElectronicList(model, user);
    }
}
