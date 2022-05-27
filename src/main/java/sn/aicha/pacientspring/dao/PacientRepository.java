package sn.aicha.pacientspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.aicha.pacientspring.entities.Patient;

public interface PacientRepository extends JpaRepository<Patient,Long> {
    
}
