package com.invillia.acme.Repository;


import com.invillia.acme.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long> {


    OrderItem findFirstByDescriptionAndUnitPrice(String itemDescription, Double itemPrice);

}
