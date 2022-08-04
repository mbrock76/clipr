package com.clipr.stores.controller;

import com.clipr.stores.model.Store;
import com.clipr.stores.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService myStoreService;

    @PostMapping
    public void createStore(@RequestBody Store myStore){ myStoreService.postStore(myStore); }

    @GetMapping
    public List<Store> getAllStores(){ return myStoreService.getAllStores(); }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Integer id){ return myStoreService.getStoreById(id); }

    @GetMapping("/company/{company}")
    public List<Store> getStoresByCompany(@PathVariable String company){
        return myStoreService.getStoresByCompany(company); }

    @PutMapping
    public void updateStore(@RequestBody Store myStore){ myStoreService.postStore(myStore); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){ myStoreService.deleteStoreById(id); }

}
