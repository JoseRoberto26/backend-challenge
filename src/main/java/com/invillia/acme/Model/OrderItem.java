package com.invillia.acme.Model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
//@Table(name = "orderItem")
public class OrderItem {

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@NotNull
    //@Size(max = 160)
    //@Column(name = "description")
    private String description;

    //@NotNull
    //@Column(name = "unit_price")
    private Double unitPrice;

    //@NotNull

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    //@Column(name = "quantity")
    private Long quantity;


}
