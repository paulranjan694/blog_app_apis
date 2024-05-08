package com.example.blogappapis.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private String userId;

    @NotEmpty
    @Size(min=4, message = "User name must be min 4 chars !!")
    private String name;

    @Email(message = "Email is not valid!!")
    private String email;

    @NotEmpty
    private String about;

    @NotEmpty
    @Size(min=3, max=10, message = "Password should be min 3 chars and max 10 chars!!")
    private String password;
}
