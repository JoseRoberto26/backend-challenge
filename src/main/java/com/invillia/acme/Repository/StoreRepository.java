package com.invillia.acme.Repository;

import com.invillia.acme.Model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

    Store findByIdAndNameContainingAndAddressContaining(Long id, String name, String address);
}
