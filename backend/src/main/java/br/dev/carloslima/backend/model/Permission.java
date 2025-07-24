package br.dev.carloslima.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_permissions")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermissions;
    private String permission;

    public Permission() {
    }

    public Permission(Integer idPermissions, String permission) {
        this.idPermissions = idPermissions;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(permission, that.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(permission);
    }
}
