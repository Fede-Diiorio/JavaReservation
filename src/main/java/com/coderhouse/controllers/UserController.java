package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.dtos.UserReqDTO;
import com.coderhouse.dtos.UserResDTO;
import com.coderhouse.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResDTO>> getAllUsers() {
        List<UserResDTO> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDTO> getUserById(@PathVariable Long id) {
        UserResDTO user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResDTO> createUser(@RequestBody UserReqDTO userReqDTO) {
        UserResDTO newUser = userService.save(userReqDTO);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResDTO> updateUser(@PathVariable Long id, @RequestBody UserReqDTO userReqDTO) {
        try {
            UserResDTO updatedUser = userService.update(id, userReqDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
