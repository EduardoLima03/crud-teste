package br.dev.carloslima.backend.repository;

import br.dev.carloslima.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findByActive(short active);
}
