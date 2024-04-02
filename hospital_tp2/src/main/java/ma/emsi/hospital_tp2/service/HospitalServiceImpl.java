package ma.emsi.hospital_tp2.service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital_tp2.entities.Consultation;
import ma.emsi.hospital_tp2.entities.Medecin;
import ma.emsi.hospital_tp2.entities.Patient;
import ma.emsi.hospital_tp2.entities.RendezVous;
import ma.emsi.hospital_tp2.repositories.ConsultationRepository;
import ma.emsi.hospital_tp2.repositories.MedecinRepository;
import ma.emsi.hospital_tp2.repositories.PatientRepository;
import ma.emsi.hospital_tp2.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRdv(RendezVous rdv) {

        return rendezVousRepository.save(rdv);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
