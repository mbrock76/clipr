package com.clipr.users_stores.controller;

import com.clipr.users_stores.model.UserStore;
import com.clipr.users_stores.service.UsersStoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users_stores")
public class UsersStoresController {

    @Autowired
    UsersStoresService myUsersStoresService;

    @PostMapping
    public void postUserStore(@RequestBody UserStore myUserStore){ myUsersStoresService.postUserStore(myUserStore); }

    @GetMapping
    public List<UserStore> getAllUsersStores(){ return myUsersStoresService.getAllUsersStores(); }

    @GetMapping("/{id}")
    public UserStore getUserStoreById(@PathVariable Integer id){ return myUsersStoresService.getUserStoreById(id); }

    @GetMapping("/user_id/{id}")
    public String getUsersByStoreId(@PathVariable Integer id){ return myUsersStoresService.getUsersByStoreId(id); }

    @GetMapping("/store_id/{id}")
    public String getStoresByUserId(@PathVariable Integer id){ return myUsersStoresService.getStoresByUserId(id); }

    //there is no updating a user x store record, dont use this
    @PutMapping
    public void putUserStore(@RequestBody UserStore myUserStore){ myUsersStoresService.postUserStore(myUserStore); }

    @DeleteMapping("/{id}")
    public void deleteUserStoreById(@PathVariable Integer id){ myUsersStoresService.deleteUserStoreById(id); }

    @DeleteMapping("/user_id/{id}")
    public void deleteAllByUserId(@PathVariable Integer id){ myUsersStoresService.deleteAllByUserId(id); }

    @DeleteMapping("/store_id/{id}")
    public void deleteAllByStoreId(@PathVariable Integer id){ myUsersStoresService.deleteAllByStoreId(id); }

}
