package com.prashanth.olx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanth.olx.repositry.UserRepository;
import com.prashanth.olx.user.User;

@Service
public class UserServiceimpl implements UserService {
      
	@Autowired
	 UserRepository userreprository;
	 
	@Override
	public String authuntication(User user) {
	
		User usernamerepo=userreprository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(usernamerepo != null) {
			return "your successfully login";
		}else {
		return "Username and password are incorect"; 
		}
	}

	@Override
	public User registration(User user) {
		return userreprository.save(user);
	}

	@Override
	public List<User> userDetials() {
		return (List<User>) userreprository.findAll();
	}

	@Override
	public boolean delete(User user) {
		User usernamerepo=userreprository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(usernamerepo != null) {
			userreprository.delete(usernamerepo);
			return true;
		}
		return false;
	}


}
