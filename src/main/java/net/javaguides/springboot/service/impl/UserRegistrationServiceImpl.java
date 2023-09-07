package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRegistrationRepo;
import net.javaguides.springboot.service.UserRegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String registerUser(UserDto userDto) {
            User user = modelMapper.map(userDto,User.class);
            userRegistrationRepo.save(user);
            return "User Saved !" ;
    }
}
