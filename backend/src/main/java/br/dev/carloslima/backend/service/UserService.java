package br.dev.carloslima.backend.service;

import br.dev.carloslima.backend.model.PermissionModel;
import br.dev.carloslima.backend.model.UserModel;
import br.dev.carloslima.backend.model.dto.CreateUserDto;
import br.dev.carloslima.backend.model.dto.UpdateUserDto;
import br.dev.carloslima.backend.repository.PermissionRepository;
import br.dev.carloslima.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    private PermissionRepository permissionRepository;

    @Autowired
    public UserService(BCryptPasswordEncoder encoder, PermissionRepository permissionRepository) {
        this.encoder = encoder;
        this.permissionRepository = permissionRepository;
    }
    /***
     * Lista todos os usuarios
     * @return Lista de UserModel
     */
    public List<UserModel> listAll(){
        return userRepository.findAll();
    }

    /***
     * Lista todos os usuarios ativo.
     * @return
     */
    public List<UserModel> listAllActive(){
        return userRepository.findByActive((short) 1);
    }

    public UserModel findUser(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    /***
     * Valva o novo usuario
     * @param dto
     * @return
     */
    public UserModel created (CreateUserDto dto){

        try {
            UserModel userEtity = new UserModel(dto.getName(), dto.getSurname(), dto.getEmail(),
                    encoder.encode(dto.getPassword()));
            Set<PermissionModel> permissions = dto.getPermissionIds().stream().map(
                    id -> permissionRepository.findById(id).orElseThrow(()-> new RuntimeException("Permissão não encontrada: " + id))
            ).collect(Collectors.toSet());
            userEtity.setPermissions(permissions);
            return userRepository.save(userEtity);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Atualiza um usuario pelo ID, podendo muda so um campo ou mais de um.
     * @param id
     * @param dto
     * @return
     */
    public UserModel update(Integer id, UpdateUserDto dto) {

        try{
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (dto.name() != null) user.setName(dto.name());
        if (dto.surname() != null) user.setSurname(dto.surname());
        if (dto.email() != null) user.setEmail(dto.email());
        if (dto.password() != null) user.setPassword(encoder.encode(dto.password())); // se usar senha
        if(dto.active() != null) user.setActive(dto.active());

        user.setUpdateDate(LocalDateTime.now());

        return userRepository.save(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public String delete(Integer id){
        try {
            UserModel user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            userRepository.delete(user);
            return "Usuário deletado com sucesso!";

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuário: " + e.getMessage());
        }
    }
}
