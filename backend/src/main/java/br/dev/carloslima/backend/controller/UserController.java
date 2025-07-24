package br.dev.carloslima.backend.controller;

import br.dev.carloslima.backend.model.UserModel;
import br.dev.carloslima.backend.model.dto.CreateUserDto;
import br.dev.carloslima.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> users = userService.listAllActive();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserDto userDto){
        try {
            return ResponseEntity.ok().body("Registrado com sucesso");
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body("Não foi possivel salvar");
        }
    }
}
