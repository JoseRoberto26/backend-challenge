package com.invillia.acme.Service;


import com.invillia.acme.Exception.ObjectNotFoundException;
import com.invillia.acme.Model.Store;
import com.invillia.acme.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {


    @Autowired
    StoreRepository storeRepository;

    public List<Store> getAlLStores(){
       return storeRepository.findAll();
    }

    public Store getStoreByParameters(Long id, String name, String address){
        return storeRepository.findByIdAndNameContainingAndAddressContaining(id, name, address);
    }

    public boolean storeExist(Store store){
        Store store1 = storeRepository.findFirstByNameAndAddress(store.getName(), store.getAddress());
        if(store1 == null){
            return false;
        }
        return true;
    }

    public void createStore(Store store){

        storeRepository.save(store);
        return;
    }

    public void updateStoreInfo(Store store){
        Store store1 = storeRepository.findById(store.getId())
                .map(newStore -> {
                    newStore.setName(store.getName());
                    newStore.setAddress(store.getAddress());
                    return  storeRepository.save(newStore);
                }).orElseThrow(() -> new ObjectNotFoundException("Store with id " + store.getId() + " doest not exist"));
    }

}
