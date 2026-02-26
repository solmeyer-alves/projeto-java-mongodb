package com.solmayer.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solmayer.workshopmongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> listAll(){
		User u1 = new User("1", "Penny Miranda", "penny@gmail.com");
		User u2 = new User("2", "Lion Belmont", "lion@gmail.com");	
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(u1, u2));
		return ResponseEntity.ok().body(list);
	}
	
}
