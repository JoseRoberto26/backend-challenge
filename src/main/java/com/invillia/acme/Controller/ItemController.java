package com.invillia.acme.Controller;


import com.invillia.acme.Model.OrderItem;
import com.invillia.acme.Service.ItemService;
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
    ItemService itemService;

    @RequestMapping(value = "client/items", method = RequestMethod.GET)
    public List<OrderItem> getAllItems(){
        return itemService.getAllItems();
    }

    @RequestMapping(value = "admin/items", method = RequestMethod.POST)
    public ResponseEntity createItem(@RequestBody OrderItem item){
        itemService.createItem(item);
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }



}
