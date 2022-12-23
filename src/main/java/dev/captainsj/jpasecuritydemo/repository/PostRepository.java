package dev.captainsj.jpasecuritydemo.repository;

import dev.captainsj.jpasecuritydemo.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
