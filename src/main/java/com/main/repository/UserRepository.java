package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.models.User;

public interface UserRepository extends JpaRepository<User, String>{

}
