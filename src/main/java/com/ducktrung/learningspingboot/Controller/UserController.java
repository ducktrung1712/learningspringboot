package com.ducktrung.learningspingboot.Controller;

import com.ducktrung.learningspingboot.DTO.request.ApiResponse;
import com.ducktrung.learningspingboot.DTO.request.UserCreationRequest;
import com.ducktrung.learningspingboot.DTO.request.UserUpdateRequest;
import com.ducktrung.learningspingboot.DTO.response.UserResponse;
import com.ducktrung.learningspingboot.Entity.User;
import com.ducktrung.learningspingboot.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request)); // Gọi setResult đúng cách
        return apiResponse;
    }
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId")String userId){
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}