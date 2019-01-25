package com.invillia.acme.Repository;


import com.invillia.acme.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    Order findByIdAndOrderAddressContainingAndConfirmationDateContainingAndStatusContaining(Long id, String address, Timestamp confirmationDate, String status);
}
