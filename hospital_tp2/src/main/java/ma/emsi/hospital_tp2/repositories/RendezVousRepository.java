package ma.emsi.hospital_tp2.repositories;

import ma.emsi.hospital_tp2.entities.Patient;
import ma.emsi.hospital_tp2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}
