package com.invillia.acme.Model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id


import java.security.Timestamp;

//@Entity
//@Table(name = "payment")
public class Payment {

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@NotNull
    //@Size(max = 100)
    //@Column(name = "status")
    private String status;

    //@NotNull
    //@Size(max = 16)
    //@Column(name = "cc_number")
    protected Long creditCardNumber;

    //@NotNull
    // @Column(name = "payment_date")
    private Timestamp paymentDate;


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
}
