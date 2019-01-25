package com.invillia.acme.Controller;


import com.invillia.acme.Model.OrderItem;
import com.invillia.acme.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<OrderItem> getAllItems(){
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public ResponseEntity createItem(@RequestBody OrderItem item){
        try{
            itemRepository.save(item);
        }
        catch (Exception e){
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return responseEntity;
        }
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }



}
