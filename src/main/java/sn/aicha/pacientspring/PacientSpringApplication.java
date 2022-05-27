package sn.aicha.pacientspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.aicha.pacientspring.dao.PacientRepository;
import sn.aicha.pacientspring.entities.Patient;

import java.util.Date;

@SpringBootApplication
public class PacientSpringApplication {


    public static void main(String[] args) {

        SpringApplication.run(PacientSpringApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PacientRepository pacientRepository){
        return args -> {
            pacientRepository.save(
                    new Patient(null,"ba","aicha",new Date(),false,12)
            );

            pacientRepository.save(
                    new Patient(null,"ba","faty",new Date(),true,22)
            );

            pacientRepository.save(
                    new Patient(null,"ba","bitty",new Date(),false,42)
            );
            pacientRepository.findAll().forEach(patient -> System.out.println(patient.getPrenom()));
        };

    }


}
