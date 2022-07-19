package com.clipr.user.controller;

import com.clipr.user.model.User;
import com.clipr.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService myUserService;

    @PostMapping
    public void createNewUser(@RequestBody User myUser){

        myUser.setPass_word(BCrypt.hashpw(myUser.getPass_word(), BCrypt.gensalt()));
        myUserService.createNewUser(myUser);
    }

    @PostMapping("/checkpwd")
    public boolean checkPassword(@RequestBody User temp){

        User myUser = myUserService.getUserById(temp.getUser_id());
        return BCrypt.checkpw(temp.getPass_word(), myUser.getPass_word());
    }

    @GetMapping
    public List<User> getAllUsers(){ return myUserService.getAllUsers(); }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){ return myUserService.getUserById(id); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){ myUserService.deleteUserById(id); }
}
