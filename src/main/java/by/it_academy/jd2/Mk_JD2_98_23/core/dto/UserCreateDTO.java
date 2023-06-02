package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserCreateDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private ArrayList<UserRoleDTO> roles;

    public UserCreateDTO(String firstName, String lastName, String username, String password,
                         LocalDate dateOfBirth, ArrayList<UserRoleDTO> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.roles = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<UserRoleDTO> roles) {
        this.roles = roles;
    }

    public void addRole(UserRoleDTO role) {
        this.roles.add(role);
    }
}
