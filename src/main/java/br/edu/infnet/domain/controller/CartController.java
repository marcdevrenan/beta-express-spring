package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Cart;
import br.edu.infnet.domain.model.Product;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.CartService;
import br.edu.infnet.domain.service.CustomerService;
import br.edu.infnet.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/cart")
    public String createOrder(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("customers", customerService.getList(user));
        model.addAttribute("products", productService.getList(user));

        return "/cart/create";
    }

    @PostMapping(value = "/cart/create")
    public String create(Model model, Cart cart, @RequestParam String[] productsId, @SessionAttribute("user") User user) {
        List<Product> products = new ArrayList<Product>();

        for (String id : productsId) {
            products.add(productService.getById(Integer.valueOf(id)));
        }

        cart.setProducts(products);
        cart.setUser(user);
        cartService.create(cart);

        String message = "The cart order " + cart.getDescription() + " was successfully registered!";
        model.addAttribute("message", message);

        return getOrderList(model, user);
    }

    @GetMapping(value = "/cart/list")
    public String getOrderList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("cart", cartService.getList(user));

        return "/cart/list";
    }

    @GetMapping(value = "/cart/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user) {
        Cart cart = cartService.getById(id);
        cartService.delete(id);

        String message = "The cart order" + cart.getDescription() + "was successfully deleted!";

        model.addAttribute("message", message);

        return getOrderList(model, user);
    }
}
