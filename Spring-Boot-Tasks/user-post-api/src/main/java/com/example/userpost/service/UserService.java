package com.example.userpost.service;

import com.example.userpost.dto.*;
import com.example.userpost.exception.ResourceNotFoundException;
import com.example.userpost.mapper.PostMapper;
import com.example.userpost.mapper.UserMapper;
import com.example.userpost.model.Post;
import com.example.userpost.model.User;
import com.example.userpost.repository.PostRepository;
import com.example.userpost.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public UserService(UserRepository userRepository,
                       PostRepository postRepository,
                       UserMapper userMapper,
                       PostMapper postMapper) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userMapper = userMapper;
        this.postMapper = postMapper;
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return userMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toResponseDTOList(users);
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userMapper.updateEntity(user, dto);
        User updated = userRepository.save(user);
        return userMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getPostsByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        List<Post> posts = postRepository.findByUserId(userId);
        return postMapper.toResponseDTOList(posts);
    }

    @Transactional(readOnly = true)
    public List<UserWithPostsDTO> getAllUsersWithPosts() {
        List<User> users = userRepository.findAllWithPosts();
        return userMapper.toUserWithPostsDTOList(users);
    }

    @Transactional(readOnly = true)
    public UserWithPostsDTO getUserWithPostsById(Long id) {
        User user = userRepository.findByIdWithPosts(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toUserWithPostsDTO(user);
    }
}
