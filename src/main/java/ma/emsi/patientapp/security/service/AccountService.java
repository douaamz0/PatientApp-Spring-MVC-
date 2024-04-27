package ma.emsi.patientapp.security.service;

import ma.emsi.patientapp.security.entities.AppRole;
import ma.emsi.patientapp.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username,String password,String email,String confirmPassword);
    AppRole addnewRole(String role);
    void addRoleToUser(String username,String role);
    void removeRole(String username,String role);
    AppUser loadUserByUsername(String username);
}
