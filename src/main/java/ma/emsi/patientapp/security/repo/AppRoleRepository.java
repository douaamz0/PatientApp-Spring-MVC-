package ma.emsi.patientapp.security.repo;

import ma.emsi.patientapp.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
