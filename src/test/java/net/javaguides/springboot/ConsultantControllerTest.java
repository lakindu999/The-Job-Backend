package net.javaguides.springboot;

import net.javaguides.springboot.entity.Consultant;
import net.javaguides.springboot.repository.ConsultantRepository;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest

public class ConsultantControllerTest {

    @Autowired
    private ConsultantRepository consultantRepository;

    @Test
    public void testConsultantSave() {
        Consultant consultant = new Consultant();
        consultant.setId(7);
        consultant.setConsultantName("Nadeeranga");
        consultant.setEmail("nadderanga@email.com");
        consultant.setPassword("1234");
        consultant.setConsultantNumber(786675645);
        consultant.setSpecializedCountry("UAE");
        consultant.setAvailableDay("wednesday,friday");
        consultant.setTimeSlot("1.00 p.m - 6.00 p.m");
        consultantRepository.save(consultant);
        assertNotNull(consultantRepository.findById(6).get());
    }

    @Test
    public void testReadAllConsultants() {
        List<Consultant> list1 = consultantRepository.findAll();
        assertThat(list1).size().isGreaterThan(0);
    }

    @Test
    public void testDeleteConsultants() {
        consultantRepository.deleteById(1);
        assertThat(consultantRepository.existsById(1)).isFalse();
    }

    @Test
    public void testUpdateConsultants() {
        Consultant consultant = consultantRepository.findById(2).get();
        consultant.setEmail("Shan2008@gmail.com");
        consultantRepository.save(consultant);
        assertNotEquals("Keyboard", consultantRepository.findById(2).get().getEmail());
    }
}
