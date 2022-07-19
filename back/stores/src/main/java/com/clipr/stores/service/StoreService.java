package com.clipr.stores.service;

import com.clipr.stores.repository.StoreRepo;
import com.clipr.stores.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {

    @Autowired
    StoreRepo myStoreRepo;

    //get a list of stores
    public List<Store> getAllStores(){ return myStoreRepo.findAll(); }

    //get one store with supplied id
    public Store getStoreById(Integer id){ return myStoreRepo.findById(id).orElse(new Store()); }

    //create a new store record
    public void createNewStore(Store myStore){ myStoreRepo.save(myStore); }

    //get a list of stores with a supplied company name
    public List<Store> getStoresByCompany(String company){ return myStoreRepo.findBy()}




}
