package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public String createUser() {
        return "/user/create";
    }

    @PostMapping(value = "/user/create")
    public String create(Model model, User user) {
        userService.create(user);

        model.addAttribute("message", "The user " + user.getEmail() + " was successfully created!");

        return "redirect:/";
    }

    @GetMapping(value = "/user/list")
    public String getUserList(Model model) {
        model.addAttribute("list", userService.getList());

        return "/user/list";
    }

    @GetMapping(value = "/user/{id}/delete")
    public String delete(Model model, @PathVariable Integer id) {
        userService.delete(id);

        return "redirect:/user/list";
    }
}
