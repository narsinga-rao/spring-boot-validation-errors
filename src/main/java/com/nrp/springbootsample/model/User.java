package com.nrp.springbootsample.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @NotNull(message = "Name is required")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
    }

}
