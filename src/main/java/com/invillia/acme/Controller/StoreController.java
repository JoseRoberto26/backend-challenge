package com.invillia.acme.Controller;


import com.invillia.acme.Model.Store;
import com.invillia.acme.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(value= "client/stores", method = RequestMethod.GET)
    public ResponseEntity<List<Store>> getStores(){
        List<Store> stores = storeService.getAlLStores();
        if(stores.isEmpty()){
            return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }

    @RequestMapping(value= "client/store")
    public ResponseEntity<Store> getStoreByParameter(@RequestParam Long id, @RequestParam String name, @RequestParam String address){
        Store store = storeService.getStoreByParameters(id, name, address);
        if(store == null){
            return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Store>(store, HttpStatus.OK);
    }


    @RequestMapping(value = "admin/store/", method = RequestMethod.POST)
    public ResponseEntity createStore(@RequestBody Store store){
        if(storeService.storeExist(store)){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        storeService.createStore(store);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "admin/store/{storeId}", method = RequestMethod.PUT)
    public ResponseEntity updateStore(@RequestBody Store store, @PathVariable Long storeId){

        storeService.updateStoreInfo(store);

        return new ResponseEntity(HttpStatus.OK);
    }

}
