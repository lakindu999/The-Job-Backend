package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.AdminLoginDto;

import net.javaguides.springboot.entity.Admin;

import net.javaguides.springboot.repository.AdminLoginRepo;

import net.javaguides.springboot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminLoginController {

    @Autowired
    private AdminLoginRepo adminLoginRepo;

    //Admin Login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AdminLoginDto adminLoginDto) {
        String email = adminLoginDto.getEmail();
        String password = adminLoginDto.getPassword();

        Admin admin = adminLoginRepo.findByEmailAndPassword(email,password);
        // Admin admin = adminLoginRepo.findByEmailAndPassword(email, password);
        if (admin != null) {
            // Admin authenticated successfully
            return  Response.responseBuilder("User Login Successfully.", HttpStatus.OK, adminLoginRepo.findByEmailAndPassword(email, password));

        } else {
            // Invalid credentials
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Request User Not Found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

}
