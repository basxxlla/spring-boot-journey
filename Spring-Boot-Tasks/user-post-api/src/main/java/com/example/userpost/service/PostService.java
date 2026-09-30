package com.example.userpost.service;

import com.example.userpost.dto.*;
import com.example.userpost.exception.ResourceNotFoundException;
import com.example.userpost.mapper.PostMapper;
import com.example.userpost.model.Post;
import com.example.userpost.model.User;
import com.example.userpost.repository.PostRepository;
import com.example.userpost.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository,
                       PostMapper postMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    @Transactional
    public PostResponseDTO createPost(PostRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));
        Post post = postMapper.toEntity(dto, user);
        Post saved = postRepository.save(post);
        return postMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public PostResponseDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return postMapper.toResponseDTO(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postMapper.toResponseDTOList(posts);
    }

    @Transactional
    public PostResponseDTO updatePost(Long id, PostRequestDTO dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));
        postMapper.updateEntity(post, dto, user);
        Post updated = postRepository.save(post);
        return postMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PostWithUserDTO> getAllPostsWithUsers() {
        List<Post> posts = postRepository.findAllWithUser();
        return postMapper.toPostWithUserDTOList(posts);
    }

    @Transactional(readOnly = true)
    public PostWithUserDTO getPostWithUserById(Long id) {
        Post post = postRepository.findByIdWithUser(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return postMapper.toPostWithUserDTO(post);
    }
}
