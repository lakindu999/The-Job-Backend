package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant,Integer> {
}
