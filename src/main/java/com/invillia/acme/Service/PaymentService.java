package com.invillia.acme.Service;

import com.invillia.acme.Model.Payment;
import com.invillia.acme.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderService orderService;

    public void createPaymentForOrder(Payment payment){
        if(orderService.orderExist(payment.getOrder())){
            Instant now = Instant.now();
            Timestamp timestamp = Timestamp.from(now);
            payment.setPaymentDate(timestamp);
            payment.getOrder().setStatus("Confirmed");
            paymentRepository.save(payment);
            orderService.updateOrderStatus(payment.getOrder(), timestamp);
        }
    }

}
