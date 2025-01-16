package com.ducktrung.learningspingboot.Mapper;

import com.ducktrung.learningspingboot.DTO.request.PermissionRequest;
import com.ducktrung.learningspingboot.DTO.response.PermissionResponse;
import com.ducktrung.learningspingboot.Entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}