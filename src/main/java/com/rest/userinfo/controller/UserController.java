package com.rest.userinfo.controller;


import com.rest.userinfo.entity.User;
import com.rest.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/saveuser")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allusers=userService.getAllUsers();
        return new ResponseEntity<>(allusers,HttpStatus.OK);
    }


    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id)
    {

        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id)
    {
        User user= userService.getUserById(id).getBody();
        userService.deleteUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }





}
