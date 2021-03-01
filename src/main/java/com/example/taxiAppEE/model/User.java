package com.example.taxiAppEE.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double spentMoney;
    @Setter(AccessLevel.NONE)
    private Role role;

    public User(String firstName,
                String lastName,
                String email,
                String password,
                Role role) {

        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.spentMoney=0.0;
        this.role=role;
    }

    public void setRole(Role role) {
        this.role=role;
    }

    public void setRole(String role) {
        this.role=Role.getRole(role);
    }

}
