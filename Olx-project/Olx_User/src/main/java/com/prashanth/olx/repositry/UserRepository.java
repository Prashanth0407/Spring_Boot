package com.prashanth.olx.repositry;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prashanth.olx.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	
      User findByUsernameAndPassword(String username,String password);
      
      User findByUsername(String username);


}
