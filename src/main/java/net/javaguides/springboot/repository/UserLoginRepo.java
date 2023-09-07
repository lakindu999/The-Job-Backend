package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserLoginRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM User WHERE email = :email AND password = :password", nativeQuery = true)
    User findByEmailAndPassword(@Param("email") String name, @Param("password") String password);
}
