package br.edu.infnet.domain.service;

import br.edu.infnet.domain.model.Cart;
import br.edu.infnet.domain.model.User;
import br.edu.infnet.domain.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void create(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getList() {
        return (List<Cart>) cartRepository.findAll();
    }

    public List<Cart> getList(User user) {
        return cartRepository.getList(user.getId(), Sort.by(Sort.Direction.ASC, "description"));
    }

    public Cart getById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Integer getQty() {
        return (int) cartRepository.count();
    }

    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }
}
