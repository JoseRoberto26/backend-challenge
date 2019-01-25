package com.invillia.acme.Service;

import com.invillia.acme.Exception.ObjectAlreadyExistsException;
import com.invillia.acme.Exception.ObjectNotFoundException;
import com.invillia.acme.Model.OrderItem;
import com.invillia.acme.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void itemExist(OrderItem item){
        OrderItem item1 = itemRepository.findById(item.getId()).orElseThrow(() -> new ObjectNotFoundException("Item with id " +item.getId()+ " does not exists"));
    }

    public void createItem(OrderItem item){
        OrderItem item1 = itemRepository.findFirstByDescriptionAndUnitPrice(item.getDescription(), item.getUnitPrice());
        if(item1 == null){
            itemRepository.save(item);
            return;
        }
        throw new ObjectAlreadyExistsException("Item already exists");
    }

    public List<OrderItem> getAllItems(){
        return itemRepository.findAll();
    }
}
