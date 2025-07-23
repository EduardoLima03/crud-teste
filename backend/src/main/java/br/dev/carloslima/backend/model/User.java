package br.dev.carloslima.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsers;
    private String name;
    private String surname;
    private String password;
    private short active;
    private LocalDateTime creationData;
    private LocalDateTime updateDate;

    public User() {
    }

    public User(Integer idUsers, String name, String surname, String password, short active, LocalDateTime creationData,
                LocalDateTime updateDate) {
        this.idUsers = idUsers;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.active = active;
        this.creationData = creationData;
        this.updateDate = updateDate;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public LocalDateTime getCreationData() {
        return creationData;
    }

    public void setCreationData(LocalDateTime creationData) {
        this.creationData = creationData;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUsers, user.idUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUsers);
    }
}
