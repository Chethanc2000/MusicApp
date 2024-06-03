package com.project.musicapp.service;

import com.project.musicapp.entity.User;

public interface UserService {

	public void saveUser(User user);

	public boolean emailExists(User user);

	public boolean validUser(String email, String password);

	public String getRole(String email);



}
