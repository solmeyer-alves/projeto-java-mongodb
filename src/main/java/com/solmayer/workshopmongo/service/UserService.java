package com.solmayer.workshopmongo.service;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repository.findById(obj.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));		
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
