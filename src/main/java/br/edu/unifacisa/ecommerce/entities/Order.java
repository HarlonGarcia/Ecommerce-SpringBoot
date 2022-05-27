package br.edu.unifacisa.ecommerce.entities;

import br.edu.unifacisa.ecommerce.dto.UserDto;
import br.edu.unifacisa.ecommerce.enums.OrderStatus;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.UUID;

public class Order implements Serializable {
    private static final long serialVersionUID = -1491910900926211586L;
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String id;
    private Instant moment;
    private OrderStatus orderStatus;
    private UserDto client;

    public Order() {
    }
    public Order(Instant moment, UserDto client) {
        this.id = UUID.randomUUID().toString();
        this.moment = moment;
        this.orderStatus = OrderStatus.NOT_SHIPPED;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
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
