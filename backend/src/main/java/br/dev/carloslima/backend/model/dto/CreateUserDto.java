package br.dev.carloslima.backend.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

import java.util.Set;

public class CreateUserDto {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

    Set<Integer> permissionIds;

    public Set<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public CreateUserDto(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
