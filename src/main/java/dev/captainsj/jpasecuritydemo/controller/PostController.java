package dev.captainsj.jpasecuritydemo.controller;

import dev.captainsj.jpasecuritydemo.model.Post;
import dev.captainsj.jpasecuritydemo.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    private final PostRepository posts;

    public PostController(PostRepository posts) {
        this.posts = posts;
    }


    @GetMapping
    public Iterable<Post> findAllPost() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable("id") Post post) {
        return post;
    }
}
