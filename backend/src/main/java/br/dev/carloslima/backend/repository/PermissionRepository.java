package br.dev.carloslima.backend.repository;

import br.dev.carloslima.backend.model.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionModel, Integer> {
}
