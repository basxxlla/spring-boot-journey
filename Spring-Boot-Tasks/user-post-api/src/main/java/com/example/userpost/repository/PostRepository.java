package com.example.userpost.repository;

import com.example.userpost.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);

    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.user")
    List<Post> findAllWithUser();

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.user WHERE p.id = :id")
    Optional<Post> findByIdWithUser(Long id);
}
