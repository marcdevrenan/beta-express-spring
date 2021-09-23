package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("user")
@Controller
public class AccessController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClothingService clothingService;

    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private GroceryService groceryService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        inventory(model);
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

        return "redirect:/login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        User user = userService.validate(email, password);

        if (user != null) {
            model.addAttribute("user", user);
            inventory(model);

            return "/index";
        } else {
            model.addAttribute("message", "Invalid authentication for " + email);

            return "/login";
        }
    }

    @GetMapping(value = "/inventory")
    public String inventory(Model model) {
        Map<String, Integer> mapAll = new HashMap<String, Integer>();
        mapAll.put("Users", userService.getQty());
        mapAll.put("Customers", customerService.getQty());
        mapAll.put("Carts", cartService.getQty());
        mapAll.put("Products", productService.getQty());
        mapAll.put("Clothes", clothingService.getQty());
        mapAll.put("Electronics", electronicService.getQty());
        mapAll.put("Groceries", groceryService.getQty());

        model.addAttribute("inventory", mapAll);

        return "redirect:/index";
    }
}
