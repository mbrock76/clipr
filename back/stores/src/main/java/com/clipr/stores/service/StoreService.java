package com.clipr.stores.service;

import com.clipr.stores.repository.StoreRepo;
import com.clipr.stores.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class StoreService {

    @Autowired
    StoreRepo myStoreRepo;

    //create or update a store record
    public void postStore(Store myStore){ myStoreRepo.save(myStore); }

    //get a list of stores
    public List<Store> getAllStores(){ return myStoreRepo.findAll(); }

    //get one store matching a supplied id
    public Store getStoreById(Integer id){ return myStoreRepo.findById(id).orElse(new Store()); }

    //get a list of stores with a supplied company name
    public List<Store> getStoresByCompany(String company){ return myStoreRepo.findByCompany(company); }

    //get a list of Stores filtered by user id
    public List<Store> getStoresByUserId(Integer id){

        WebClient myWebClient = WebClient.create();

        //call the users x stores microservice and get a string of store ids
        WebClient.ResponseSpec myReSpec = myWebClient.get()
                .uri("http://localhost:8085/users_stores/user_id/" + id)
                .retrieve();

        //process the response into ints
        String temp = myReSpec.bodyToMono(String.class).block();
        int[] storeIds = Arrays.stream(temp.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //get the store objects using the store ids
        List<Store> myStores = new ArrayList<Store>();

        for(int each:storeIds){
            myStores.add(myStoreRepo.findById(each).get());
        }

        return myStores;
    }

    //remove a store record
    public void deleteStoreById(Integer id){ myStoreRepo.deleteById(id); }
}
