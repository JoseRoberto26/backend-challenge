package com.invillia.acme.Controller;

import com.invillia.acme.Model.Payment;
import com.invillia.acme.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(name = "client/payment", method = RequestMethod.POST)
    public ResponseEntity createPayment(@RequestBody Payment payment){

        paymentService.createPaymentForOrder(payment);

        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }


}
