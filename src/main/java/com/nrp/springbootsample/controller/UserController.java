package com.nrp.springbootsample.controller;

import com.nrp.springbootsample.model.ErrorResponseMessage;
import com.nrp.springbootsample.model.ResponseMessage;
import com.nrp.springbootsample.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(new ErrorResponseMessage("Error", errors));
        }
        return ResponseEntity.ok(new ResponseMessage("Success", "User created successfully"));
    }

}
