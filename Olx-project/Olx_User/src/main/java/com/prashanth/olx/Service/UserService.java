package com.prashanth.olx.Service;

import java.util.List;

import com.prashanth.olx.user.User;

public interface UserService {
	
	public String authuntication(User user);
	public User registration(User user);
	public List<User> userDetials();
	public boolean delete(User user);

	

}
