package com.invillia.acme.Model;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "order")
public class Order {

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@NotNull
    //@Size(max = 160)
    //@Column(name = "address")
    private String orderAddress;

    //@NotNull
    //@Column(name = "confirmation_date")
    private Timestamp confirmationDate;

    //@NotNull
    //@Size(max = 100)
    //@Column(name = "status")
    private String status;

    //@OneToMany (targetEntity=OrderItem.class)
    //@JoinColumn(name = "fk_order_item", nullable = false)
    private OrderItem items;


    public Long getId() {
        return id;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Timestamp getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Timestamp confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderItem getItems() {
        return items;
    }

    public void setItems(OrderItem items) {
        this.items = items;
    }

}
