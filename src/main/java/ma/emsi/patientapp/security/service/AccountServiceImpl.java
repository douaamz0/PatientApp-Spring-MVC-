package ma.emsi.patientapp.security.service;

import jakarta.transaction.Transactional;
import ma.emsi.patientapp.security.entities.AppRole;
import ma.emsi.patientapp.security.entities.AppUser;
import ma.emsi.patientapp.security.repo.AppRoleRepository;
import ma.emsi.patientapp.security.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder)
    {
        this.appRoleRepository=appRoleRepository;
        this.appUserRepository=appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser!=null)throw new RuntimeException("this user already exists !");
        if(!password.equals(confirmPassword))throw new RuntimeException("password not match !");
        AppUser user=AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        AppUser savedAppUser =appUserRepository.save(user);
        return savedAppUser;
    }

    @Override
    public AppRole addnewRole(String role) {

        AppRole appRole=appRoleRepository.findById(role).orElse(null);
        if(appRole!=null)throw new RuntimeException("this role already exists!");
        appRole=AppRole.builder()
                .role(role)
                .build();
        return appRoleRepository.save(appRole);

    }

    @Override
    public void addRoleToUser(String username, String role) {
         AppUser appUser=appUserRepository.findByUsername(username);
         AppRole appRole=appRoleRepository.findById(role).get();
         appUser.getRoles().add(appRole);

    }

    @Override
    public void removeRole(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findById(role).get();
        appUser.getRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
