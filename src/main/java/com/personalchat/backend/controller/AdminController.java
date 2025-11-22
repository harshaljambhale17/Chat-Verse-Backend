package com.personalchat.backend.controller;

import com.personalchat.backend.entity.User;
import com.personalchat.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable Long id) {
        return userRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
