package com.ducktrung.learningspingboot.Service;

import com.ducktrung.learningspingboot.DTO.request.UserCreationRequest;
import com.ducktrung.learningspingboot.DTO.request.UserUpdateRequest;
import com.ducktrung.learningspingboot.DTO.response.UserResponse;
import com.ducktrung.learningspingboot.Entity.User;
import com.ducktrung.learningspingboot.Exception.AppException;
import com.ducktrung.learningspingboot.Exception.ErrorCode;
import com.ducktrung.learningspingboot.Mapper.UserMapper;
import com.ducktrung.learningspingboot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    public User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);

    }
    public  UserResponse updateUser(String userId, UserUpdateRequest request){
        User user= userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User Not Found"));

        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("User Not Found")));
    }

}