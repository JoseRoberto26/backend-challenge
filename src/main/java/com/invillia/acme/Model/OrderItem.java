package com.invillia.acme.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "order_item_id_seq")
    @SequenceGenerator(name="order_item_id_seq", sequenceName = "order_item_id_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 160)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "unit_price")
    private Double unitPrice;

    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
