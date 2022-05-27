package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.dto.UserDto;
import br.edu.unifacisa.ecommerce.entities.Order;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    public UserService userService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public String placeAnOrder(Order order) throws ContentNotFoundException {
        boolean userExists = userService.checkUserExistence(order.getClient().getUsername());
        if (!userExists) {
            Order newOrder = new Order(order.getMoment(), order.getClient());
            User user = userService.findByUsername(order.getClient().getUsername());
            UserDto userOrding = user.toDto();
            orderRepository.placeAnOrder(newOrder);
            user.addOrder(newOrder.getId());
            return userOrding.getUsername();
        }
        throw new ContentNotFoundException("User not found");
    }


}
