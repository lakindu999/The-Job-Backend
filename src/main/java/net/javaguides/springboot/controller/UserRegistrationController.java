package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserRegistrationService;
import net.javaguides.springboot.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRegister")
@CrossOrigin
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody UserDto userDto){
        userRegistrationService.registerUser(userDto);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", userDto), HttpStatus.CREATED);
        return responseEntity;
    }

}
