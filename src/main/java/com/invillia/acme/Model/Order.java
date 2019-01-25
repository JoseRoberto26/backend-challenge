package com.invillia.acme.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name="order_id_seq", sequenceName = "order_id_seq")
    @Column(name = "id")
    private Long id;

    @Size(max = 160)
    @Column(name = "address")
    private String orderAddress;

    @Column(name = "confirmation_date")
    @JsonIgnore
    private Timestamp confirmationDate;

    @Size(max = 100)
    @Column(name = "status")
    private String status;

    @OneToMany (fetch = FetchType.LAZY, targetEntity = OrderItem.class)
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Payment.class)
    @JsonIgnore
    private Payment payment;

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @JsonProperty("confirmationDate")
    public Timestamp getConfirmationDate() {
        return confirmationDate;
    }

    @JsonIgnore
    public void setConfirmationDate(Timestamp confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
