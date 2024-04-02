package ma.emsi.hospital_tp2.repositories;

import ma.emsi.hospital_tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
