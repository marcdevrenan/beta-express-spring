package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Customer;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer")
    public String createCustomer() {
        return "/customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String create(Model model, Customer customer, @SessionAttribute("user") User user) {
        customer.setUser(user);
        customerService.create(customer);

        String message = "The customer " + customer.getFirstName() + " was successfully created!";
        model.addAttribute("message", message);

        return getCustomerList(model, user);
    }

    @GetMapping(value = "/customer/list")
    public String getCustomerList(Model model, @SessionAttribute("user") User user) {
        model.addAttribute("customers", customerService.getList(user));

        return "/customer/list";
    }

    @GetMapping(value = "/customer/{id}/delete")
    public String delete(Model model, @PathVariable Integer id, @SessionAttribute("user") User user) {
        Customer customer = customerService.getById(id);

        String message;
        try {
            customerService.delete(id);
            message = "The customer " + customer.getFirstName() + " was successfully deleted!";
        } catch (Exception e) {
            message = "It was impossible to delete the customer " + customer.getFirstName();
        }

        model.addAttribute("message", message);

        return getCustomerList(model, user);
    }
}
