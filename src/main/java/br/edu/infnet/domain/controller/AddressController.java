package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/getCep")
    public String getCep(Model model, @RequestParam String cep) {
        model.addAttribute("address", addressService.getCep(cep));

        return "/user/create";
    }
}
