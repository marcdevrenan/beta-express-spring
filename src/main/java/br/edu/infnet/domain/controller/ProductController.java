package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Product;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/list")
    public String getProductList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("products", productService.getList(user));

        return "/product/list";
    }

    @GetMapping(value = "/product/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user){
        Product product = productService.getById(id);

        String message;
        try {
            productService.delete(id);
            message = "The product " + product.getName() + " was successfully deleted!";
        } catch (Exception e) {
            message = "It was impossible to delete the product " + product.getName();
        }

        model.addAttribute("message", message);

        return getProductList(model, user);
    }
}
