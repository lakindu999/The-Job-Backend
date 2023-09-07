package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.UserLoginDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserLoginRepo;
import net.javaguides.springboot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserLoginController {

    @Autowired
    private UserLoginRepo userLoginRepo;

    //User Login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto) {
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();

        User user = userLoginRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            // User authenticated successfully
            return  Response.responseBuilder("User Login Successfully.", HttpStatus.OK, userLoginRepo.findByEmailAndPassword(email, password));

        } else {
            // Invalid credentials
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Request User Not Found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

}
