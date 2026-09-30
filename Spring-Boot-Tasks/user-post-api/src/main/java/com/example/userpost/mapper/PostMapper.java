package com.example.userpost.mapper;

import com.example.userpost.dto.*;
import com.example.userpost.model.Post;
import com.example.userpost.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post toEntity(PostRequestDTO dto, User user) {
        if (dto == null) {
            return null;
        }
        Post post = new Post();
        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());
        post.setUser(user);
        return post;
    }

    public void updateEntity(Post post, PostRequestDTO dto, User user) {
        if (dto == null || post == null) {
            return;
        }
        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());
        if (user != null) {
            post.setUser(user);
        }
    }

    public PostResponseDTO toResponseDTO(Post post) {
        if (post == null) {
            return null;
        }
        Long userId = post.getUser() != null ? post.getUser().getId() : null;
        return new PostResponseDTO(
                post.getId(),
                post.getText(),
                post.getImagePath(),
                userId
        );
    }

    public PostWithUserDTO toPostWithUserDTO(Post post) {
        if (post == null) {
            return null;
        }
        UserResponseDTO userDTO = null;
        if (post.getUser() != null) {
            userDTO = new UserResponseDTO(
                    post.getUser().getId(),
                    post.getUser().getName(),
                    post.getUser().getAge()
            );
        }
        return new PostWithUserDTO(
                post.getId(),
                post.getText(),
                post.getImagePath(),
                userDTO
        );
    }

    public List<PostResponseDTO> toResponseDTOList(List<Post> posts) {
        return posts.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<PostWithUserDTO> toPostWithUserDTOList(List<Post> posts) {
        return posts.stream()
                .map(this::toPostWithUserDTO)
                .collect(Collectors.toList());
    }

    public List<PostSummaryDTO> toPostSummaryList(List<Post> posts) {
        return posts.stream()
                .map(p -> new PostSummaryDTO(p.getId(), p.getText(), p.getImagePath()))
                .collect(Collectors.toList());
    }
}
