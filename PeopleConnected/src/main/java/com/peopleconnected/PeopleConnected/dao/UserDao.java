package com.peopleconnected.PeopleConnected.dao;

import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<UserProfile,Integer> {
    List<UserProfile> findByNameContainingIgnoreCase(String name);
    List<UserProfile> findByExpertiseContainingIgnoreCase(String expertise);
    List<UserProfile> findByBioContainingIgnoreCase(String bio);
}
