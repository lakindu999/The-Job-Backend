package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Appointment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@EnableJpaRepositories
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
