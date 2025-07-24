package br.dev.carloslima.backend.config;

import br.dev.carloslima.backend.model.PermissionModel;
import br.dev.carloslima.backend.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PermissionRepository repository;

    @Override
    public void run(String... args) throws Exception {
        PermissionModel p1 = new PermissionModel("ADMIN");
        PermissionModel p2 = new PermissionModel("USER");

        repository.saveAll(Arrays.asList(p1,p2));
    }
}
