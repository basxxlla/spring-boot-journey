package com.example.userpost.config;

import com.example.userpost.model.Post;
import com.example.userpost.model.User;
import com.example.userpost.repository.PostRepository;
import com.example.userpost.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public DataLoader(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Create sample users (password meets validation rules)
        User u1 = new User("AhmedHassan", 25, "Pass@1234");
        User u2 = new User("SaraAliOmar", 22, "Secure#99");
        User u3 = new User("OmarKhaled", 30, "MyP@ssw0rd");

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        // Create sample posts (text >= 20 characters)
        Post p1 = new Post("This is my first post about learning Spring Boot framework!", "/images/post1.jpg");
        p1.setUser(u1);

        Post p2 = new Post("Sharing some thoughts on software engineering and best practices.", "/images/post2.jpg");
        p2.setUser(u1);

        Post p3 = new Post("Hello everyone, this is a welcome post from Sara about coding!", "/images/post3.png");
        p3.setUser(u2);

        Post p4 = new Post("Omar here! Talking about database design and REST API architecture.", null);
        p4.setUser(u3);

        postRepository.save(p1);
        postRepository.save(p2);
        postRepository.save(p3);
        postRepository.save(p4);

        System.out.println("========================================");
        System.out.println("Sample data loaded successfully!");
        System.out.println("Users: 3 | Posts: 4");
        System.out.println("========================================");
    }
}
