package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.ConsultantLoginDto;
import net.javaguides.springboot.entity.Consultant;
import net.javaguides.springboot.repository.ConsultantRepo;
import net.javaguides.springboot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consultant/login")
@CrossOrigin
public class ConsultantLoginController {

    @Autowired
    private ConsultantRepo consultantRepo;

    //Consultant Login
    @PostMapping("/save")
    public ResponseEntity<Object> login(@RequestBody ConsultantLoginDto consultantLoginDto, HttpSession session) {
        String email = consultantLoginDto.getEmail();
        String password = consultantLoginDto.getPassword();

        Consultant consultant = consultantRepo.findByEmailAndPassword(email, password);
        if (consultant != null) {
            // User authenticated successfully
            session.setAttribute("email", email);

            return Response.responseBuilder("User Login Successfully.", HttpStatus.OK, consultantRepo.findByEmailAndPassword(email, password));
        } else {
            // Invalid credentials
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Request User Not Found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
