package br.edu.unifacisa.ecommerce.entities;

import br.edu.unifacisa.ecommerce.dto.UserDto;
import br.edu.unifacisa.ecommerce.enums.OrderStatus;
import java.io.Serializable;
import java.util.UUID;

public class Order implements Serializable {
    private static final long serialVersionUID = -1491910900926211586L;
    private String id;
    private String moment;
    private OrderStatus orderStatus;
    private Cart cart;
    private UserDto client;

    public Order() {
    }
    public Order(String moment, Cart cart, UserDto client) {
        this.id = UUID.randomUUID().toString();
        this.moment = moment;
        this.cart = cart;
        this.orderStatus = OrderStatus.NOT_SHIPPED;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public void setOrderStatus(int statusCode) {
        this.orderStatus = OrderStatus.valueOf(statusCode);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public UserDto getClient() {
        return client;
    }
}
