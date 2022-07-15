package com.example.clipr.service;

import com.example.clipr.model.User;
import com.example.clipr.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo myUserRepo;

    //get a list of all users
    public List<User> getAllUsers() { return myUserRepo.findAll(); }

    //get one user with supplied id
    public User findUserById(Integer id){ return myUserRepo.findById(id).orElse(new User()); }

    //create a new user record
    public void createNewUser(User myUser){ myUserRepo.save(myUser); }

    //update a user record
    //public void updateUser(User myUser){ myUserRepo.}

}
