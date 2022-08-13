package com.prashanth.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashanth.olx.Service.*;
import com.prashanth.olx.jwtutil.JwtUtil;
import com.prashanth.olx.user.AuthRequest;
import com.prashanth.olx.user.User;

@RestController
@RequestMapping("/user")
public class UserController {
     
	@Autowired
    UserService userservice;
	  @Autowired
	    private JwtUtil jwtUtil;
	   
	  @Autowired
	    private AuthenticationManager authenticationManager;
	    
	  @Autowired
	    private CustomUserDetials service;
	    
	
	@PostMapping("/authenticate")
	public  ResponseEntity<String> authentication(@RequestBody AuthRequest authrequest){
		 authenticationManager.authenticate(new  UsernamePasswordAuthenticationToken(authrequest.getUsername(),authrequest.getPassword()));
		return new ResponseEntity<>(jwtUtil.generateToken(authrequest.getUsername()),HttpStatus.ACCEPTED);
	}
	@PostMapping("/register")
	public ResponseEntity<User> registration(@RequestBody User user){
		return new ResponseEntity<>(userservice.registration(user),HttpStatus.ACCEPTED);
		  }
    
	@GetMapping()
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<>(userservice.userDetials(),HttpStatus.OK);
	}
	@DeleteMapping("/logout")
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user){
		return new ResponseEntity<>(userservice.delete(user),HttpStatus.OK);
	}
	 @PostMapping("/validate")
	    public Boolean validateToken(@RequestHeader String token, @RequestBody AuthRequest authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        UserDetails userdetails = service.loadUserByUsername(authRequest.getUsername());
	        return jwtUtil.validateToken(token, userdetails);
	    }

}
