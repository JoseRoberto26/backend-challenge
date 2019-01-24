package com.invillia.acme.Model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
//@Table(name = "stores")
public class Store {

    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //@Column(name = "id")
    private Long id;

    //@NotNull
    //@Size(max = 100)
    //@Column(name = "name")
    private String name;

    //@NotNull
    //@Size(max = 160)
    //@Column(name = "address")
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
