package com.solmayer.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solmayer.workshopmongo.domain.Post;
import com.solmayer.workshopmongo.repository.PostRepository;
import com.solmayer.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	

	public Post findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
}
