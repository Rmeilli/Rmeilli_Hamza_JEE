package ma.enset.hopitale.repository;

import ma.enset.hopitale.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
