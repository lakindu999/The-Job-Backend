package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;

public interface UserRegistrationService {
    String registerUser(UserDto userDto);
}
