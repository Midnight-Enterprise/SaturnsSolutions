package com.saturnssolutions.TakeMoney.controllers;

import com.saturnssolutions.TakeMoney.models.UserModel;
import com.saturnssolutions.TakeMoney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/users")
    public List<UserModel> listAllUsers() {
        return userService.listAllUsers();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> users(@PathVariable Integer id) {
        try {
            UserModel user = userService.getUser(id);
            return new ResponseEntity<UserModel>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @PostMapping("/users")
    public void users(@RequestBody UserModel user) {
        userService.saveUser(user);
    }
    @CrossOrigin
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody UserModel user, @PathVariable Integer id) {
        try {
            UserModel existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) {

        userService.deleteUser(id);
    }

    @CrossOrigin
    @GetMapping("/users/total")
    public List<Object[]> getTotal(){
        return userService.getTotal();
    }
}
