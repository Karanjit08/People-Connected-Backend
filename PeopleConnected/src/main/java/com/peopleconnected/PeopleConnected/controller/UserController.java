package com.peopleconnected.PeopleConnected.controller;


import com.peopleconnected.PeopleConnected.entities.UserProfile;
import com.peopleconnected.PeopleConnected.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserProfile> addProfile(@RequestBody UserProfile userProfile) {
        return this.userService.addProfile(userProfile);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable int id, @RequestBody UserProfile userProfile) {
        return this.userService.updateProfile(id, userProfile);
    }

}
