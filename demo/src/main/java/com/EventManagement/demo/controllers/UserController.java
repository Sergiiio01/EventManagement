package com.EventManagement.demo.controllers;

import com.EventManagement.demo.models.User;
import com.EventManagement.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public HashMap<String, List<User>> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/{eventName}")
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user, @PathVariable String eventName){
        return this.userService.newUser(user, eventName);
    }

    @GetMapping("/{eventName}")
    public List<User> getUsersByEvent(@PathVariable String eventName){
        return this.userService.getUsersByEvent(eventName);
    }

    @DeleteMapping
    public void cancelReservation(@RequestBody HashMap<String, String> email){
        this.userService.cancelReservation(email.get("email"));
    }

}
