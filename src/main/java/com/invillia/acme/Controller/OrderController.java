package com.invillia.acme.Controller;

import com.invillia.acme.Exception.ObjectNotFoundException;
import com.invillia.acme.Model.Order;
import com.invillia.acme.Model.OrderItem;
import com.invillia.acme.Repository.ItemRepository;
import com.invillia.acme.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/order")
    public Order getOrderByParameters(@RequestParam Long id, @RequestParam String orderAddress, @RequestParam Timestamp confirmationDate, @RequestParam String status){
        return orderRepository.findByIdAndOrderAddressContainingAndConfirmationDateContainingAndStatusContaining(id, orderAddress, confirmationDate, status);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody Order order){
        System.out.println("Creating Order " + order.getId());


        order.getItems().forEach(orderItem -> {
            OrderItem item =  itemRepository.findFirstByDescriptionAndUnitPrice(orderItem.getDescription(), orderItem.getUnitPrice());
            if(item == null){
                throw new ObjectNotFoundException("Item with description " + item.getDescription() + " does not exist");
            }
            else{
                orderItem.setId(item.getId());
            }
        });
        try {
            if(order.getStatus() == "Confirmed"){
                Instant now = Instant.now();
                Timestamp timestamp = Timestamp.from(now);
                order.setConfirmationDate(timestamp);
            }
            else{
                Timestamp timestamp = null;
                order.setConfirmationDate(timestamp);
            }
            orderRepository.save(order);
        }
        catch (Exception e){
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return responseEntity;
        }
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }


}
