package com.peopleconnected.PeopleConnected.services;


import com.peopleconnected.PeopleConnected.dao.UserDao;
import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
