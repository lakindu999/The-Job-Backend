package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ConsultantRepo extends JpaRepository<Consultant,Integer> {

    @Query(value = "SELECT * FROM Consultant WHERE email = :email AND password = :password", nativeQuery = true)
    Consultant findByEmailAndPassword(@Param("email") String name, @Param("password") String password);
}
