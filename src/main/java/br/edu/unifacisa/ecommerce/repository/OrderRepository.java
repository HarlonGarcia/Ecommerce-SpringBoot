package br.edu.unifacisa.ecommerce.repository;

import br.edu.unifacisa.ecommerce.entities.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public List<Order> findAll() {
        return orders;
    }

    public void placeAnOrder(Order order) {
        orders.add(order);
    }
}
