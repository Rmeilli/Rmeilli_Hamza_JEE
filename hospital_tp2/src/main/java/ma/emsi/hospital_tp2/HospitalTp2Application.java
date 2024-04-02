package ma.emsi.hospital_tp2;

import ma.emsi.hospital_tp2.entities.*;
import ma.emsi.hospital_tp2.repositories.ConsultationRepository;
import ma.emsi.hospital_tp2.repositories.MedecinRepository;
import ma.emsi.hospital_tp2.repositories.PatientRepository;
import ma.emsi.hospital_tp2.repositories.RendezVousRepository;
import ma.emsi.hospital_tp2.service.HospitalServiceImpl;
import ma.emsi.hospital_tp2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalTp2Application {

    public static void main(String[] args) {

        SpringApplication.run(HospitalTp2Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Amine").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setMalade(false);
                patient.setDateNaissance(new Date());
                hospitalService.savePatient(patient);
            });
            Stream.of("Aziz","Housni","Dounia").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin=medecinRepository.findByNom("Aziz");

            RendezVous rdv= new RendezVous();
            rdv.setDate(new Date());
            rdv.setPatient(patient);
            rdv.setMedecin(medecin);
            rdv.setStatus(StatusRDV.PENDING);
            hospitalService.saveRdv(rdv);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation= new Consultation();
            consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation");
            hospitalService.saveConsultation(consultation);
        };
    }



}
