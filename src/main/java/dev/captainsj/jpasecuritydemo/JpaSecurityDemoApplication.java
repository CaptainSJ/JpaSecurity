package dev.captainsj.jpasecuritydemo;

import dev.captainsj.jpasecuritydemo.model.Post;
import dev.captainsj.jpasecuritydemo.model.User;
import dev.captainsj.jpasecuritydemo.repository.PostRepository;
import dev.captainsj.jpasecuritydemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSecurityDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder passwordEncoder) {

        return args -> {

            users.save(new User(1, "user", passwordEncoder.encode("user123"), "ROLE_USER"));
            users.save(new User(2, "admin",passwordEncoder.encode( "admin123"), "ROLE_USER,ROLE_ADMIN"));

            posts.save(new Post("Hello World", "hello-world", "This is my first post", "CaptainSJ"));

        };
    }

}
