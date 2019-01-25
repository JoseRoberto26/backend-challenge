package com.invillia.acme.Repository;

import com.invillia.acme.Model.Store;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

    Store findByIdAndNameContainingAndAddressContaining(Long id, String name, String address);

    Store findFirstByNameAndAddress(String name, String address);
}
