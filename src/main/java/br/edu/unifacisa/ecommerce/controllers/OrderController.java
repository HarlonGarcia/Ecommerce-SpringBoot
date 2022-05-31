package br.edu.unifacisa.ecommerce.controllers;

import br.edu.unifacisa.ecommerce.entities.Order;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeAnOrder(@RequestBody Order order) {
        try {
            String message = orderService.placeAnOrder(order);
            return new ResponseEntity<String>("Order placed successfully by " + message + "!", HttpStatus.CREATED);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return new ResponseEntity<List<Order>>(orderService.findAll(), HttpStatus.OK);
    }
}
