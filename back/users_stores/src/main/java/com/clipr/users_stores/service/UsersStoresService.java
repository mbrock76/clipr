package com.clipr.users_stores.service;

import com.clipr.users_stores.repository.UsersStoresRepo;
import com.clipr.users_stores.model.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersStoresService {

    @Autowired
    UsersStoresRepo myUsersStoresRepo;

    //create a new user x store record
    public void postUserStore(UserStore myUserStore){ myUsersStoresRepo.save(myUserStore); }

    //get a userstore with a supplied user_store_id
    public UserStore getUserStoreById(Integer id){ return myUsersStoresRepo.findById(id).orElse(new UserStore()); }

    //get a list of all userstore records
    public List<UserStore> getAllUsersStores(){ return myUsersStoresRepo.findAll(); }

    //get a string of user ids with a supplied store id
    public String getUsersByStoreId(Integer id){

        List<UserStore> temp = myUsersStoresRepo.findBystoreId(id);

        //concatenate user ids into one string
        String userIds = "";
        for(UserStore each:temp){

            userIds += each.getUserId() + " ";
        }

        return userIds;
    }

    //get a string of store ids with a supplied user id
    public String getStoresByUserId(Integer id){

        List<UserStore> temp = myUsersStoresRepo.findByuserId(id);

        //concatenate store ids into one string
        String storeIds = "";
        for(UserStore each:temp){

            storeIds += each.getStoreId() + " ";
        }

        return storeIds;
    }

    //delete a user x store record with a supplied id
    public void deleteUserStoreById(Integer id){ myUsersStoresRepo.deleteById(id); }

    //delete all user x store records that match a supplied user id
    public void deleteAllByUserId(Integer id){ myUsersStoresRepo.deleteAllByuserId(id); }

    //delete all user x store records that match a supplied store id
    public void deleteAllByStoreId(Integer id){ myUsersStoresRepo.deleteAllBystoreId(id); }

}
