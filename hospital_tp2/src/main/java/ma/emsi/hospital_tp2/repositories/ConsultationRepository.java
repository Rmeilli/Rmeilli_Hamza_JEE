package ma.emsi.hospital_tp2.repositories;

import ma.emsi.hospital_tp2.entities.Consultation;
import ma.emsi.hospital_tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}