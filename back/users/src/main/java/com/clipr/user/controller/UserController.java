package com.clipr.user.controller;

import com.clipr.user.model.User;
import com.clipr.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService myUserService;

    @PostMapping
    public void createNewUser(@RequestBody User myUser){

        myUser.setPassWord(BCrypt.hashpw(myUser.getPassWord(), BCrypt.gensalt()));
        myUserService.postUser(myUser);
    }

    @PostMapping("/checkpwd")
    public boolean checkPassword(@RequestBody User temp){

        User myUser = myUserService.getUserById(temp.getUser_id());
        return BCrypt.checkpw(temp.getPassWord(), myUser.getPassWord());
    }

    @GetMapping
    public List<User> getAllUsers(){ return myUserService.getAllUsers(); }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){ return myUserService.getUserById(id); }

    @GetMapping("/coupon_id/{id}")
    public List<User> getUsersByCouponId(@PathVariable Integer id){ return myUserService.getUsersByCouponId(id); }

    @PutMapping
    public void updateUser(@RequestBody User myUser){ myUserService.postUser(myUser); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){ myUserService.deleteUserById(id); }

}
