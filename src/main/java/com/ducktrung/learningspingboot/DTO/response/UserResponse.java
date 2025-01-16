package com.ducktrung.learningspingboot.DTO.response;

import com.ducktrung.learningspingboot.Entity.Role;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
     String id;
     String username;
     String firstname;
     String lastname;
     LocalDate dob;

     Set<RoleResponse> roles;
}
