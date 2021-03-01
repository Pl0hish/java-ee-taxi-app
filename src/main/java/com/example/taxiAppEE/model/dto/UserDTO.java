package com.example.taxiAppEE.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}