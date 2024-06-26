package com.rest.userinfo.service;


import com.rest.userinfo.entity.User;
import com.rest.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepo userRepo;


    public User saveUser(User user)
    {
        User saveduser =userRepo.save(user);
        return saveduser;
    }


    public List<User> getAllUsers()
    {
        List<User> allUsers=userRepo.findAll();
        return allUsers;
    }


    public ResponseEntity<User> getUserById(int id)
    {
        Optional<User> retreivedUser=userRepo.findById(id);

        if(retreivedUser.isEmpty())
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(retreivedUser.get(),HttpStatus.OK);
        }
    }


    public void deleteUser(User user)
    {
        userRepo.delete(user);
    }
}
