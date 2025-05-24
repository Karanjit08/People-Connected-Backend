package com.peopleconnected.PeopleConnected.services;


import com.peopleconnected.PeopleConnected.dao.UserDao;
import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<UserProfile> addProfile(UserProfile userProfile) {
        return new ResponseEntity<>(userDao.save(userProfile),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserProfile> updateProfile(int id, UserProfile userProfile) {
        Optional<UserProfile> userProfileOptional = userDao.findById(id);
        if (userProfileOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserProfile updateUser = userProfileOptional.get();

        updateUser.setName(userProfile.getName());
        updateUser.setEmail(userProfile.getEmail());
        updateUser.setBio(userProfile.getBio());
        updateUser.setExpertise(userProfile.getExpertise());
        updateUser.setServices(userProfile.getServices());

        return new ResponseEntity<>(userDao.save(updateUser),HttpStatus.OK);


    }

    @Override
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        try {
            return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<UserProfile>> getUsersByName(String name) {
        try {
            return new ResponseEntity<>(userDao.findByNameContainingIgnoreCase(name), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserProfile>> getUsersByExpertise(String expertise) {
        try {
            return new ResponseEntity<>(userDao.findByExpertiseContainingIgnoreCase(expertise),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserProfile>> getUsersByBio(String bio) {
        try {
            return new ResponseEntity<>(userDao.findByBioContainingIgnoreCase(bio),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }
}
