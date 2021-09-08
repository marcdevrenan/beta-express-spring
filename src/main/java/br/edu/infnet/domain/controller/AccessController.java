package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AccessController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String homePage() {
        return "/index";
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "/login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");

        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        User user = userService.validate(email, password);

        if (user != null) {
            model.addAttribute("user", user);

            return "/index";
        } else {
            model.addAttribute("message", "Invalid authentication for " + email);

            return "/login";
        }
    }
}
