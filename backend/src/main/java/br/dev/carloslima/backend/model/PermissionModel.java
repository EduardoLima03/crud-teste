package br.dev.carloslima.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_permissions")
public class PermissionModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermissions;
    private String permission;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<UserModel> users = new HashSet<>();

    public PermissionModel() {
    }

    public PermissionModel(String permission) {
        this.permission = permission;
    }

    public Integer getIdPermissions() {
        return idPermissions;
    }

    public void setIdPermissions(Integer idPermissions) {
        this.idPermissions = idPermissions;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Set<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PermissionModel that = (PermissionModel) o;
        return Objects.equals(permission, that.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(permission);
    }}
