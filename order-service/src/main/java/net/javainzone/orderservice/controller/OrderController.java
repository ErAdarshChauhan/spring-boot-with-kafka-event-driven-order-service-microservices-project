package net.javainzone.orderservice.controller;

import net.javainzone.model.GenericResponseDTO;
import net.javainzone.model.order.Order;
import net.javainzone.model.order.OrderEvent;
import net.javainzone.orderservice.kafka.OrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<GenericResponseDTO<String>> placeOrder(@RequestBody Order order){
        //create OrderEvent
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrderEventStatus("Pending");
        orderEvent.setOrderEventMessage("Order is in Pending state");
        orderEvent.setOrder(order);
        orderProducer.sendMessageToTopic(orderEvent);

        return new ResponseEntity<>(GenericResponseDTO.ok("Order has been placed successfully"), HttpStatus.OK);
    }
}
