package com.invillia.acme.Controller;


import com.invillia.acme.Model.Store;
import com.invillia.acme.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreRepository storeRepository;


    @RequestMapping(value= "/stores", method = RequestMethod.GET)
    public List<Store> getStores(){
        return storeRepository.findAll();
    }

    @RequestMapping(value= "/store")
    public Store getStoreByParameter(@RequestParam Long id, @RequestParam String name, @RequestParam String address){
        return storeRepository.findByIdAndNameContainingAndAddressContaining(id, name, address);
    }


    @RequestMapping(value = "/store/", method = RequestMethod.POST)
    public ResponseEntity createStore(@RequestBody Store store){
        System.out.println("Creating Store " + store.getName());

        try {
            storeRepository.save(store);
        }
        catch (Exception e){
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return responseEntity;
        }
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }

    @RequestMapping(value = "/store/{storeId}", method = RequestMethod.PUT)
    public ResponseEntity updateStore(@RequestBody Store store, @PathVariable Long storeId){
        Object storeFound = storeRepository.findById(storeId);
        if(storeFound == null){
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return responseEntity;
        }
        else{
            try{
                storeRepository.findById(storeId).map( newStoreFound -> {
                    newStoreFound.setAddress(store.getAddress());
                    newStoreFound.setName(store.getName());
                    return storeRepository.save(newStoreFound);
                });
                ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
                return responseEntity;
            }
            catch (Exception e){
                ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                return responseEntity;
            }
        }
    }

}
