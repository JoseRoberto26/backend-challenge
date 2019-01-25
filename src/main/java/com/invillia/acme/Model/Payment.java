package com.invillia.acme.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.sql.Timestamp;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "payment_id_seq")
    @SequenceGenerator(name="payment_id_seq", sequenceName = "payment_id_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "cc_number")
    protected Long creditCardNumber;

    @NotNull
    @Column(name = "payment_date")
    @JsonIgnore
    private Timestamp paymentDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
