package com.ducktrung.learningspingboot.DTO.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 5, message = "USERNAME_INVALID")
    String username;
    @Size(min = 3, message = "INVALID_PASSWORD")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;

}