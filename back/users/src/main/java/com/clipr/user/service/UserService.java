package com.clipr.user.service;

import com.clipr.user.repository.UserRepo;
import com.clipr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo myUserRepo;

    //create or update a user record
    public void postUser(User myUser){ myUserRepo.save(myUser); }

    //get a list of all users
    public List<User> getAllUsers() { return myUserRepo.findAll(); }

    //get one user with a matching id
    public User getUserById(Integer id){ return myUserRepo.findById(id).orElse(new User()); }

    //get a list of users filtered by user type
    //can be filtered client side

    //get a list of coupons filtered by user id
    public List<User> getUsersByCouponId(Integer id){

        WebClient myWebClient = WebClient.create();

        //call the users x coupons microservice and get a string of user ids
        WebClient.ResponseSpec myReSpec = myWebClient.get()
                .uri("http://localhost:8084/users_coupons/coupon_id/" + id)
                .retrieve();

        //process the response into ints
        String temp = myReSpec.bodyToMono(String.class).block();
        int[] userIds = Arrays.stream(temp.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //get the user objects using the user ids
        List<User> myUsers = new ArrayList<User>();

        for(int each:userIds){
            myUsers.add(myUserRepo.findById(each).get());
        }

        return myUsers;
    }

    //remove a user record
    public void deleteUserById(Integer id){ myUserRepo.deleteById(id); }

}
