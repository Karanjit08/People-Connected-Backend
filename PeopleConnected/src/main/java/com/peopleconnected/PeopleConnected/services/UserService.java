package com.peopleconnected.PeopleConnected.services;

import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<UserProfile> addProfile(UserProfile userProfile);

    ResponseEntity<UserProfile> updateProfile(int id, UserProfile userProfile);

    ResponseEntity<List<UserProfile>> getAllUsers();

    ResponseEntity<List<UserProfile>> getUsersByName(String name);

    ResponseEntity<List<UserProfile>> getUsersByExpertise(String expertise);

    ResponseEntity<List<UserProfile>> getUsersByBio(String bio);
}
