package com.invillia.acme.Controller;

import com.invillia.acme.Model.Order;
import com.invillia.acme.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "client/order")
    public Order getOrderByParameters(@RequestParam Long id, @RequestParam String orderAddress, @RequestParam Timestamp confirmationDate, @RequestParam String status){
        return orderService.findByParameters(id, orderAddress, confirmationDate, status);
    }

    @RequestMapping(value = "client/order", method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody Order order){

        orderService.createOrder(order);
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }


}
