package ma.emsi.patientapp;

import ma.emsi.patientapp.entities.Patient;
import ma.emsi.patientapp.repository.PatientRepository;
import ma.emsi.patientapp.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class PatientAppApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Douaa",new Date(),false,12));
        patientRepository.save(new Patient(null,"Amina",new Date(),true,123));
        patientRepository.save(new Patient(null,"Fatima",new Date(),false,10));
    }
    //@Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder passwordEncoder=passwordEncoder();
        return args->{
            UserDetails u1=jdbcUserDetailsManager.loadUserByUsername("user11");
            if(u1==null)
               jdbcUserDetailsManager.createUser(User.withUsername("user11").password(passwordEncoder.encode("1234"))
                    .roles("USER").build());
            UserDetails u2=jdbcUserDetailsManager.loadUserByUsername("user22");
            if(u2==null)
                jdbcUserDetailsManager.createUser(User.withUsername("user22").password(passwordEncoder.encode("1234"))
                    .roles("USER").build());
            UserDetails u3=jdbcUserDetailsManager.loadUserByUsername("admin2");
            if(u3==null)
                jdbcUserDetailsManager.createUser(User.withUsername("admin2").password(passwordEncoder.encode("1234"))
                    .roles("ADMIN","USER").build());


        };
    }
    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService)
    {
        return args->{
           // accountService.addnewRole("USER");
           // accountService.addnewRole("ADMIN");
            accountService.addNewUser("user1","1234","user1@gmail.com","1234");
            accountService.addNewUser("user2","1234","user2@gmail.com","1234");
            accountService.addNewUser("admin","1234","admin@gmail.com","1234");

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
