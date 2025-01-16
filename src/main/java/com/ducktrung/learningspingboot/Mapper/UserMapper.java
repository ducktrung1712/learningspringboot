package com.ducktrung.learningspingboot.Mapper;

import com.ducktrung.learningspingboot.DTO.request.UserCreationRequest;
import com.ducktrung.learningspingboot.DTO.request.UserUpdateRequest;
import com.ducktrung.learningspingboot.DTO.response.UserResponse;
import com.ducktrung.learningspingboot.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
