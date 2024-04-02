package ma.emsi.hospital_tp2.service;

import ma.emsi.hospital_tp2.entities.Consultation;
import ma.emsi.hospital_tp2.entities.Medecin;
import ma.emsi.hospital_tp2.entities.Patient;
import ma.emsi.hospital_tp2.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRdv(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
