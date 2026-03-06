package com.solmayer.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solmayer.workshopmongo.domain.User;
import com.solmayer.workshopmongo.dto.UserDTO;
import com.solmayer.workshopmongo.repository.UserRepository;
import com.solmayer.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
	}
	
	public User save(User obj) {
		return repository.save(obj);
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
