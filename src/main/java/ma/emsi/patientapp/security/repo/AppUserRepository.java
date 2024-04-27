package ma.emsi.patientapp.security.repo;

import ma.emsi.patientapp.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    public AppUser findByUsername(String username);
}
