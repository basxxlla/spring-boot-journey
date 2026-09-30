package com.example.userpost.mapper;

import com.example.userpost.dto.*;
import com.example.userpost.model.Post;
import com.example.userpost.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        return user;
    }

    public void updateEntity(User user, UserRequestDTO dto) {
        if (dto == null || user == null) {
            return;
        }
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
    }

    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getAge()
        );
    }

    public UserWithPostsDTO toUserWithPostsDTO(User user) {
        if (user == null) {
            return null;
        }
        List<PostSummaryDTO> postSummaries = user.getPosts() != null
                ? user.getPosts().stream()
                    .map(this::toPostSummary)
                    .collect(Collectors.toList())
                : List.of();

        return new UserWithPostsDTO(
                user.getId(),
                user.getName(),
                user.getAge(),
                postSummaries
        );
    }

    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UserWithPostsDTO> toUserWithPostsDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserWithPostsDTO)
                .collect(Collectors.toList());
    }

    private PostSummaryDTO toPostSummary(Post post) {
        return new PostSummaryDTO(
                post.getId(),
                post.getText(),
                post.getImagePath()
        );
    }
}
