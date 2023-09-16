package net.javaguides.springboot;


import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRegistrationRepo;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRegistrationControllerTest {

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Test
    public void testUserSave() {
        User user = new User();
        user.setId(7L);
        user.setFirstName("Kasun");
        user.setLastName("Wijesinghe");
        user.setEmail("kasun@email.com");
        user.setPassword("1234");
        userRegistrationRepo.save(user);
        assertNotNull(userRegistrationRepo.findById(7L).get());
    }
}
