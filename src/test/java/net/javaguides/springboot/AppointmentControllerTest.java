package net.javaguides.springboot;

import net.javaguides.springboot.entity.Appointment;
import net.javaguides.springboot.repository.AppointmentRepository;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class AppointmentControllerTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    public void testAppointmentSave() {
        Appointment appoinment = new Appointment();
        appoinment.setId(6);
        appoinment.setFirstName("gihan");
        appoinment.setLastName("devinda");
        appoinment.setContactNumber("0745564576");
        appoinment.setConsultantName("tharindu samarakoon");
        appoinment.setEmail("gihan@email.com");
        appoinment.setDate("12/04/2023");
        appointmentRepository.save(appoinment);
        assertNotNull(appointmentRepository.findById(6).get());
    }

    @Test
    public void testReadAllAppointment() {
        List<Appointment> list1 = appointmentRepository.findAll();
        assertThat(list1).size().isGreaterThan(0);
    }

    @Test
    public void testDeleteAppointment() {
        appointmentRepository.deleteById(1);
        assertThat(appointmentRepository.existsById(1)).isFalse();
    }

}
