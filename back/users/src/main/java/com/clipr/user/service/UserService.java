package com.clipr.user.service;

import com.clipr.user.repository.UserRepo;
import com.clipr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo myUserRepo;

    //get a list of all users
    public List<User> getAllUsers() { return myUserRepo.findAll(); }

    //get one user with supplied id
    public User getUserById(Integer id){ return myUserRepo.findById(id).orElse(new User()); }

    //create a new user record
    public void createNewUser(User myUser){ myUserRepo.save(myUser); }

    //remove a store record
    public void deleteUserById(Integer id){ myUserRepo.deleteById(id); }

}
