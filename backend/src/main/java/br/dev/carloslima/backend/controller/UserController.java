package br.dev.carloslima.backend.controller;

import br.dev.carloslima.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1, "Carlos", "lima", "87ds5a64d54ew6r54f5sd", (short) 1,
                LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.ok().body(u);
    }
}
