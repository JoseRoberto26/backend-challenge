package com.invillia.acme.Controller;

import com.invillia.acme.Exception.ObjectNotFoundException;
import com.invillia.acme.Model.Order;
import com.invillia.acme.Model.Payment;
import com.invillia.acme.Repository.OrderRepository;
import com.invillia.acme.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(name = "/payment", method = RequestMethod.POST)
    public ResponseEntity createPayment(@RequestBody Payment payment){
        Order orderToPay = orderRepository.findById(payment.getOrder().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Order does not exist"));
        try{
            Instant now = Instant.now();
            Timestamp timestamp = Timestamp.from(now);
            payment.setPaymentDate(timestamp);
            paymentRepository.save(payment);
            orderRepository.updateOrderStatus(payment.getOrder().getId());
        }
        catch (Exception e ){
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return responseEntity;
        }
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }


}
