package com.ducktrung.learningspingboot.Mapper;

import com.ducktrung.learningspingboot.DTO.request.PermissionRequest;
import com.ducktrung.learningspingboot.DTO.request.RoleRequest;
import com.ducktrung.learningspingboot.DTO.response.PermissionResponse;
import com.ducktrung.learningspingboot.DTO.response.RoleResponse;
import com.ducktrung.learningspingboot.Entity.Permission;
import com.ducktrung.learningspingboot.Entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}