package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AdminLoginRepo extends JpaRepository<Admin,Long> {

    @Query(value = "SELECT * FROM Admin WHERE email = :email AND password = :password", nativeQuery = true)
    Admin findByEmailAndPassword(@Param("email") String name, @Param("password") String password);
}
