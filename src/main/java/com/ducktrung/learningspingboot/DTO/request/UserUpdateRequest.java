package com.ducktrung.learningspingboot.DTO.request;

import com.ducktrung.learningspingboot.Validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

     String password;
     String firstname;
     String lastname;

     @DobConstraint(min = 18, message = "INVALID_DOB")
     LocalDate dob;
     List<String> roles;

}