package br.dev.carloslima.backend.controller;

import br.dev.carloslima.backend.model.UserModel;
import br.dev.carloslima.backend.model.dto.CreateUserDto;
import br.dev.carloslima.backend.model.dto.UpdateUserDto;
import br.dev.carloslima.backend.service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(userService.findUser(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserDto userDto){
        try {
            userService.created(userDto);
            return ResponseEntity.ok().body("Registrado com sucesso");
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body("Não foi possivel salvar");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Integer id, @RequestBody UpdateUserDto dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        try {

            return ResponseEntity.ok().body(userService.delete(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Não foi possivel deleta, usuario não encontrado");
        }
    }
}
