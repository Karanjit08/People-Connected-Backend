package com.peopleconnected.PeopleConnected.services;

import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<UserProfile> addProfile(UserProfile userProfile);

    ResponseEntity<UserProfile> updateProfile(int id, UserProfile userProfile);
}
