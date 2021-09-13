package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Electronic;
import br.edu.infnet.domain.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping(value = "/product/electronic")
    public String createElectronic() {
        return "/product/electronic/create";
    }

    @PostMapping(value = "/product/electronic/create")
    public String create(Model model, Electronic electronic) {
        electronicService.create(electronic);
        model.addAttribute("message", electronic.getName() + " has been added to system!");

        return getElectronicList(model);
    }

    @GetMapping(value = "/product/electronic/list")
    public String getElectronicList(Model model) {
        model.addAttribute("electronic", electronicService.getList());

        return "/product/electronic/list";
    }

    @GetMapping(value = "/product/electronic/{id}/delete")
    public String delete(Model model, @PathVariable Integer id) {
        Electronic electronic = electronicService.getById(id);
        electronicService.delete(id);
        model.addAttribute("message", electronic.getName() + " was successfully deleted!");

        return getElectronicList(model);
    }
}
