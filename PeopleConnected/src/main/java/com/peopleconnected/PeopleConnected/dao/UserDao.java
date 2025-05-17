package com.peopleconnected.PeopleConnected.dao;

import com.peopleconnected.PeopleConnected.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserProfile,Integer> {

}
