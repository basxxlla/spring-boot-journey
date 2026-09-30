package com.example.userpost.controller;

import com.example.userpost.dto.*;
import com.example.userpost.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * POST /posts - Create a new post (associated with a user)
     */
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO dto) {
        PostResponseDTO created = postService.createPost(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * GET /posts - Get all posts
     */
    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        List<PostResponseDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    /**
     * GET /posts/postsWithUsers - Get all posts with their users
     * (Must be declared BEFORE /{id} to avoid path conflict)
     */
    @GetMapping("/postsWithUsers")
    public ResponseEntity<List<PostWithUserDTO>> getAllPostsWithUsers() {
        List<PostWithUserDTO> posts = postService.getAllPostsWithUsers();
        return ResponseEntity.ok(posts);
    }

    /**
     * GET /posts/postWithUsers/{id} - Get one post with its user
     */
    @GetMapping("/postWithUsers/{id}")
    public ResponseEntity<PostWithUserDTO> getPostWithUserById(@PathVariable Long id) {
        PostWithUserDTO post = postService.getPostWithUserById(id);
        return ResponseEntity.ok(post);
    }

    /**
     * GET /posts/{id} - Get post by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        PostResponseDTO post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    /**
     * PUT /posts/{id} - Update post
     */
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long id,
                                                      @Valid @RequestBody PostRequestDTO dto) {
        PostResponseDTO updated = postService.updatePost(id, dto);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /posts/{id} - Delete post
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
