package com.solmayer.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.solmayer.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
