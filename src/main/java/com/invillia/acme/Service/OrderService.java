package com.invillia.acme.Service;

import com.invillia.acme.Exception.ObjectNotFoundException;
import com.invillia.acme.Model.Order;
import com.invillia.acme.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemService itemService;

    public boolean orderExist(Order order){
        Order order1 = orderRepository.findById(order.getId()).orElseThrow( () -> new ObjectNotFoundException("Order with id " +order.getId()+ " does not exists"));
        return true;
    }

    @Transactional
    public void updateOrderStatus(Order order, Timestamp confirmationDate){
        orderRepository.updateOrderStatus(order.getId(), confirmationDate);
    }

    public Order findByParameters(Long id, String orderAddress, Timestamp confirmationDate, String status ){
        return orderRepository.findByIdAndOrderAddressContainingAndConfirmationDateContainingAndStatusContaining(id, orderAddress, confirmationDate, status);
    }

    public void createOrder(Order order){
        order.getItems().forEach(orderItem -> {
            itemService.itemExist(orderItem);
        });
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
}
