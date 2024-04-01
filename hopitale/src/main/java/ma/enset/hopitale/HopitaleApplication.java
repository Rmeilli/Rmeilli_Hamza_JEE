package ma.enset.hopitale;

import ma.enset.hopitale.entities.Patient;
import ma.enset.hopitale.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitaleApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitaleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Naruto",new Date(),false,15));
        patientRepository.save(new Patient(null,"Sasuke",new Date(),false,15));
        patientRepository.save(new Patient(null,"Sakura",new Date(),false,15));



    }
}
