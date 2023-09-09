package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findByEmail(String email);


//    @Query(value = "SELECT * FROM appointment WHERE email = :email", nativeQuery = true)
//    List<Appointment> findAppointmentByEmail(@Param("email") String email);
//

}
