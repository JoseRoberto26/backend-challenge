package com.invillia.acme.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "store_id_seq")
    @SequenceGenerator(name="store_id_seq", sequenceName = "store_id_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 160)
    @Column(name = "address")
    private String address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
