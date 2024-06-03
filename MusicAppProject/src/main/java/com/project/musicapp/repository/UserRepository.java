package com.project.musicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.musicapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
