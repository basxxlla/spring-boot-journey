package com.example.userpost.controller;

import com.example.userpost.dto.*;
import com.example.userpost.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * POST /users - Create a new user
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO created = userService.createUser(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * GET /users - Get all users
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * GET /users/usersWithPost - Get all users with their posts
     * (Must be declared BEFORE /{id} to avoid path conflict)
     */
    @GetMapping("/usersWithPost")
    public ResponseEntity<List<UserWithPostsDTO>> getAllUsersWithPosts() {
        List<UserWithPostsDTO> users = userService.getAllUsersWithPosts();
        return ResponseEntity.ok(users);
    }

    /**
     * GET /users/userWithPost/{id} - Get one user with their posts
     */
    @GetMapping("/userWithPost/{id}")
    public ResponseEntity<UserWithPostsDTO> getUserWithPostsById(@PathVariable Long id) {
        UserWithPostsDTO user = userService.getUserWithPostsById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * GET /users/{id}/posts - Get all posts of a specific user
     */
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostResponseDTO>> getPostsByUserId(@PathVariable Long id) {
        List<PostResponseDTO> posts = userService.getPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }

    /**
     * GET /users/{id} - Get user by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * PUT /users/{id} - Update user
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
                                                      @Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO updated = userService.updateUser(id, dto);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /users/{id} - Delete user
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
