package com.ducktrung.learningspingboot.Controller;

import com.ducktrung.learningspingboot.DTO.request.ApiResponse;
import com.ducktrung.learningspingboot.DTO.request.PermissionRequest;
import com.ducktrung.learningspingboot.DTO.request.RoleRequest;
import com.ducktrung.learningspingboot.DTO.response.PermissionResponse;
import com.ducktrung.learningspingboot.DTO.response.RoleResponse;
import com.ducktrung.learningspingboot.Service.PermissionService;
import com.ducktrung.learningspingboot.Service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role){
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}
