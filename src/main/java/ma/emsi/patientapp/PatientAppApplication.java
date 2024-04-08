package ma.emsi.patientapp;

import ma.emsi.patientapp.entities.Patient;
import ma.emsi.patientapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientAppApplication {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }


    //@Override
//    public void run(String... args) throws Exception {
//        patientRepository.save(new Patient(null,"Douaa",new Date(),false,12));
//        patientRepository.save(new Patient(null,"Amina",new Date(),true,123));
//        patientRepository.save(new Patient(null,"Fatima",new Date(),false,10));
//    }
}
